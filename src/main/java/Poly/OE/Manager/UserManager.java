package Poly.OE.Manager;

import java.util.List;

import Poly.OE.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class UserManager {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PolyOE");
	EntityManager em = factory.createEntityManager();
	
	//XUẤT RA TẤT CẢ USER
	public void findAll() {
		String jpql = "SELECT o FROM User o";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		List<User> list = query.getResultList();
		list.forEach(user -> {
			String fullName = user.getFullname();
			boolean admin = user.getAdmin();
			System.out.println(fullName + ": "+admin);
		});
	}
	
	//TÌM DỰA TRÊN KHOÁ CHÍNH
	public void findById(String id) {
	    User user = em.find(User.class, id);
	    if (user != null) {
	        String fullname = user.getFullname();
	        System.out.println(fullname);
	    } else {
	        System.out.println("User with ID " + id + " not found.");
	    }
	}
	
	//TẠO
	public void create(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
		}
		
	}
	
	//SỬA
	public void update(String id) {
		User user = em.find(User.class, id);
		user.setFullname("Tran Vang Dang");
		user.setEmail("dang@gmail.com");
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//XOÁ
	public void deleteById(String id) {
		User user = em.find(User.class, id);
		try {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
		}
	}
	
	public void findByEmailAndRole() {
	    String jpql = "SELECT o FROM User o WHERE o.email LIKE :search AND o.admin = :role";
	    TypedQuery<User> query = em.createQuery(jpql, User.class);
	    query.setParameter("search", "%@fpt.edu.vn");
	    query.setParameter("role", false);

	    List<User> list = query.getResultList();
	    list.forEach(user -> {
	        String fullname = user.getFullname();
	        String email = user.getEmail();
	        System.out.println(fullname + " - " + email);
	    });
	}
	
	public void findUsersByPage(int pageNumber, int pageSize) {
	    String jpql = "SELECT o FROM User o";
	    TypedQuery<User> query = em.createQuery(jpql, User.class);
	    query.setFirstResult(pageNumber * pageSize); // Bắt đầu từ user thứ 10
	    query.setMaxResults(pageSize); // Số lượng user mỗi trang là 5

	    List<User> list = query.getResultList();
	    list.forEach(user -> {
	        String fullname = user.getFullname();
	        String email = user.getEmail();
	        System.out.println(fullname + " - " + email);
	    });
	}
	
}