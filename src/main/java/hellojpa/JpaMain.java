package hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Team teamA = new Team();
      teamA.setName("teamA");
      em.persist(teamA);

      Team teamB = new Team();
      teamB.setName("teamA");
      em.persist(teamB);

      Member member1 = new Member();
      member1.setUsername("member1");
      member1.setTeam(teamA);
      em.persist(member1);

      Member member2 = new Member();
      member2.setUsername("member2");
      member2.setTeam(teamB);
      em.persist(member2);

      em.flush();
      em.clear();

//      Member m = em.find(Member.class, member1.getId());

      List<Member> members = em.createQuery("select m from Member m join fetch m.team",
              Member.class)
          .getResultList();

      // SQL: select * from Member
      // SQL: select * from Team where TEAM_ID = xxx

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }

    emf.close();
  }

  private static void logic(Member m1, Member m2) {
    System.out.println("m1 == m2: = " + (m1 instanceof Member));
    System.out.println("m1 == m2: = " + (m2 instanceof Member));
  }
}
