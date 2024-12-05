package Poly.OE.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import Poly.OE.Entity.Video;
import Poly.OE.Utils.XJPA;

public class VideoDAOlmpl implements VideoDAO {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public List<Video> findAll() {
        String jpql = "SELECT v FROM Video v";
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        return query.getResultList();
    }

    @Override
    public Video findById(String id) {
        return em.find(Video.class, id);
    }

    @Override
    public void create(Video video) {
        em.getTransaction().begin();
        em.persist(video);
        em.getTransaction().commit();
    }

    @Override
    public void update(Video video) {
        em.getTransaction().begin();
        em.merge(video);
        em.getTransaction().commit();
    }

    @Override
    public void deleteById(String id) {
        Video video = em.find(Video.class, id);
        if (video != null) {
            em.getTransaction().begin();
            em.remove(video);
            em.getTransaction().commit();
        }
    }
    
    public List<Video> findVideosByKeyword(String keyword) {
        return em.createQuery(
            "SELECT v FROM Video v WHERE v.title LIKE :keyword", Video.class)
            .setParameter("keyword", "%" + keyword + "%")
            .getResultList();
    }
    
    
    public List<Video> findTop10MostLikedVideos() {
        return em.createQuery(
            "SELECT f.video FROM Favorite f GROUP BY f.video ORDER BY COUNT(f.video) DESC", Video.class)
            .setMaxResults(10)
            .getResultList();
    }
    
    
    public List<Video> findVideosWithoutLikes() {
        return em.createQuery(
            "SELECT v FROM Video v WHERE v NOT IN (SELECT f.video FROM Favorite f)", Video.class)
            .getResultList();
    }
    
    
    public List<Video> findSharedVideosIn2024() {
        return em.createQuery(
            "SELECT DISTINCT s.video FROM Share s WHERE YEAR(s.shareDate) = 2024 ORDER BY s.shareDate ASC", Video.class)
            .getResultList();
    }
    
    
    
}