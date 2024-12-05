package Poly.OE.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class XJPA {
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("PolyOE");
        } catch (Exception e) {
            throw new ExceptionInInitializerError("EntityManagerFactory initialization failed: " + e.getMessage());
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}


