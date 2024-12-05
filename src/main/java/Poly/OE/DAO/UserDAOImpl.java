package Poly.OE.DAO;

import java.awt.Polygon;
import java.util.List;

import Poly.OE.DAO.UserDAO;
import Poly.OE.Utils.XJPA;
import Poly.OE.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UserDAOImpl implements UserDAO{
	EntityManager em = XJPA.getEntityManager();
	
    @Override
    public List<User> findAll() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public User findById(String id) {
        return em.find(User.class, id);
    }

    @Override
    public void create(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public void deleteById(String id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }
    }

//	protected List<Favorite> getFavorites() {
//		return null;
//	}
    
    @Override
    public User findByIdOrEmail(String idOrEmail) {
        try {
            return em.createQuery(
                "SELECT u FROM User u WHERE u.id = :idOrEmail OR u.email = :idOrEmail", User.class)
                .setParameter("idOrEmail", idOrEmail)
                .getSingleResult();
        } catch (NoResultException e) {
            return null; // Trả về null nếu không tìm thấy
        }
    }
}