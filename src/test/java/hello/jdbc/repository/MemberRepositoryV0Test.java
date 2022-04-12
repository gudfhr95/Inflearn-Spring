package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

class MemberRepositoryV0Test {

  MemberRepositoryV0 repositoryV0 = new MemberRepositoryV0();

  @Test
  void crud() throws SQLException {
    Member member = new Member("memberV1", 10000);
    repositoryV0.save(member);
  }
}