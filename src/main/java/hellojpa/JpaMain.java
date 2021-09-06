package hellojpa;

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
      Address address = new Address("city", "street", "10000");

      Member member = new Member();
      member.setUsername("member1");
      member.setHomeAddress(address);
      em.persist(member);

      Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
      member.setHomeAddress(newAddress);

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
