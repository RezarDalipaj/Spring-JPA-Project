package com.example.jpa_springg.Repository.UserRepository;

import com.example.jpa_springg.config.EntityManagerConfig;
import com.example.jpa_springg.model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
@Component
public class UserRepositoryImpl implements UserRepository{

    private EntityManager entityManager = EntityManagerConfig.getEntityManager();
    @Override
    public User save(User u) {
        if (u.getId()!=null){
            entityManager.getTransaction().begin();
            u.setUserName(u.getUserName());
            u.setRole(u.getRole());
            u.setPassword(u.getPassword());
            entityManager.getTransaction().commit();
            System.out.println("User successfully updated");
        }
        else {
            entityManager.getTransaction().begin();
            entityManager.persist(u);
            entityManager.getTransaction().commit();
            System.out.println("User successfully added");
        }
        return u;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(User.class,id));
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> result = entityManager.createQuery("SELECT u from User u", User.class);
        return result.getResultList();
    }

    @Override
    public User delete(User u) {
        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();
        return u;
    }

    @Override
    public Optional<User> findByUsername(String uname) {
        TypedQuery<User> result = entityManager.createQuery("SELECT u FROM User u WHERE u.userName = :userName", User.class);
        result.setParameter("userName", uname);
        return Optional.ofNullable(result.getSingleResult());
    }
}
