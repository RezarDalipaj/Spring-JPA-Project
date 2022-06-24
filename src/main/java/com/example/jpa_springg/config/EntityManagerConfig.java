package com.example.jpa_springg.config;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@Component
public class EntityManagerConfig {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("new_db");
    private static final javax.persistence.EntityManager ENTITY_MANAGER = FACTORY.createEntityManager();

    public static javax.persistence.EntityManager getEntityManager() {
        return ENTITY_MANAGER;
    }
}
