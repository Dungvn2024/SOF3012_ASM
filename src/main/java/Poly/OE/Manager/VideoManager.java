package Poly.OE.Manager;


import java.util.List;

import Poly.OE.Entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class VideoManager {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("PolyOE");
    EntityManager em = factory.createEntityManager();

    // Get all videos
    public List<Video> findAll() {
        String jpql = "SELECT v FROM Video v";
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        return query.getResultList();
    }

    // Find video by ID
    public Video findById(String id) {
        return em.find(Video.class, id);
    }

    // Create a video
    public void create(Video video) {
        try {
            em.getTransaction().begin();
            em.persist(video);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    // Update a video
    public void update(Video video) {
        try {
            em.getTransaction().begin();
            
            // Check if the video exists by its primary key (or unique field)
            Video existingVideo = em.find(Video.class, video.getId());  // Assuming 'getId()' is the method to get the primary key
            if (existingVideo != null) {
                // If it exists, merge the updated video into the database
                em.merge(video);
            } else {
                System.out.println("Video not found, nothing to update.");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();  // Log the exception for debugging
        }
    }

    // Delete a video by ID
    public void deleteById(String id) {
        Video video = em.find(Video.class, id);
        if (video != null) {
            try {
                em.getTransaction().begin();
                em.remove(video);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }
}
