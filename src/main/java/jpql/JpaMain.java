package jpql;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Member member = new Member();
      member.setUsername("member1");
      member.setAge(10);
      em.persist(member);

      em.flush();
      em.clear();

      List<MemberDTO> result = em.createQuery(
              "select new jpql.MemberDTO(m.username, m.age) from Member m",
              MemberDTO.class)
          .getResultList();

      MemberDTO memberDTO = result.get(0);
      System.out.println("memberDTO = " + memberDTO.getUsername());
      System.out.println("memberDTO = " + memberDTO.getAge());

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }

    emf.close();
  }
}