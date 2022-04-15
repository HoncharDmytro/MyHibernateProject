package org.honchar.jpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import java.util.HashMap;
import java.util.Map;

public class JPASessionUtil {
    private static final Map<String, EntityManagerFactory>
            persistenceUnits = new HashMap<>();

    @SuppressWarnings("WeakerAccess")
    public static synchronized EntityManager
    getEntityManager(String persistenceUnitName) {
        persistenceUnits
                .putIfAbsent(
                        persistenceUnitName,
                        Persistence
                                .createEntityManagerFactory(
                                        persistenceUnitName
                                ));
        return persistenceUnits
                .get(persistenceUnitName)
                .createEntityManager();
    }

    public static Session getSession(String persistenceUnitName) {
        return getEntityManager(persistenceUnitName)
                .unwrap(Session.class);
    }
}