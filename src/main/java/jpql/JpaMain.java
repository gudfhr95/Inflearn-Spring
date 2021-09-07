package jpql;

import java.util.Collection;
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
      Team team = new Team();
      em.persist(team);

      Member member1 = new Member();
      member1.setUsername("관리자1");
      member1.setTeam(team);
      em.persist(member1);

      Member member2 = new Member();
      member2.setUsername("관리자2");
      member2.setTeam(team);
      em.persist(member2);

      em.flush();
      em.clear();

      String query = "select m From Team t join t.members m";

      List<Collection> result = em.createQuery(query, Collection.class)
          .getResultList();

      System.out.println("result = " + result);

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