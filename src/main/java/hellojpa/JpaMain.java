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
      Member member = new Member();
      member.setUsername("member1");
      em.persist(member);

      // flush -> commit, query

      em.flush();

      // 결과 0
      // dbconn.executeQuery("select * from member");

      for (Member member1 : resultList) {
        System.out.println("member1 = " + member1);
      }

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
