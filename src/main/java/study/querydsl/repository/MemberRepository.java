package study.querydsl.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import study.querydsl.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom,
    QuerydslPredicateExecutor<Member> {

  List<Member> findByUsername(String username);
}
