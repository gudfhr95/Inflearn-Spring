package hello.springtx.propagation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MemberServiceTest {

  @Autowired
  MemberService memberService;

  @Autowired
  MemberRepository memberRepository;

  @Autowired
  LogRepository logRepository;

  /**
   * MemberService    @Transactional:OFF
   * <p>
   * MemberRepository @Transactional:ON
   * <p>
   * logRepository    @Transactional:ON
   */
  @Test
  void outerTxOff_success() {
    // given
    String username = "outerTxOff_success";

    // when
    memberService.joinV1(username);

    // then: 모든 데이터가 정상 저장된다.
    assertTrue(memberRepository.find(username).isPresent());
    assertTrue(logRepository.find(username).isPresent());
  }

  /**
   * MemberService    @Transactional:OFF
   * <p>
   * MemberRepository @Transactional:ON
   * <p>
   * LogRepository    @Transactional:ON Exception
   */
  @Test
  void outerTxOff_fail() {
    // given
    String username = "로그예외_outerTxOff_fail";

    // when
    assertThatThrownBy(() -> memberService.joinV1(username))
        .isInstanceOf(RuntimeException.class);

    // then: 완전히 롤백되지 않고, member 데이터가 남아서 저장된다.
    assertTrue(memberRepository.find(username).isPresent());
    assertTrue(logRepository.find(username).isEmpty());
  }

  /**
   * MemberService    @Transactional:ON
   * <p>
   * MemberRepository @Transactional:OFF
   * <p>
   * LogRepository    @Transactional:OFF
   */
  @Test
  void singleTx() {
    // given
    String username = "singleTx";

    // when
    memberService.joinV1(username);

    // then: 완전히 롤백되지 않고, member 데이터가 남아서 저장된다.
    assertTrue(memberRepository.find(username).isPresent());
    assertTrue(logRepository.find(username).isPresent());
  }
}