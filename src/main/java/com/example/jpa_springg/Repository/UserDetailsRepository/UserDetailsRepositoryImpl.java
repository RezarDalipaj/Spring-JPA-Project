package com.example.jpa_springg.Repository.UserDetailsRepository;

import com.example.jpa_springg.config.EntityManagerConfig;
import com.example.jpa_springg.model.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
@Component
public class UserDetailsRepositoryImpl implements UserDetailsRepository{
    private EntityManager entityManager = EntityManagerConfig.getEntityManager();
    @Override
    public UserDetails save(UserDetails u) {
            entityManager.getTransaction().begin();
            entityManager.persist(u);
            entityManager.getTransaction().commit();
            System.out.println("User Details successfully added");
        return u;
    }

    @Override
    public Optional<UserDetails> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(UserDetails.class,id));
    }

    @Override
    public List<UserDetails> findAll() {
        TypedQuery<UserDetails> result = entityManager.createQuery("SELECT ud from UserDetails ud", UserDetails.class);
        return result.getResultList();
    }

    @Override
    public UserDetails delete(UserDetails u) {
        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();
        return u;
    }
}
