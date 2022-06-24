package com.example.jpa_springg.Repository.BookingRepository.impl;

import com.example.jpa_springg.Repository.BookingRepository.BookingRepository;
import com.example.jpa_springg.config.EntityManagerConfig;
import com.example.jpa_springg.model.Booking;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Component
public class BookingRepositoryImpl implements BookingRepository {
    private EntityManager entityManager = EntityManagerConfig.getEntityManager();

    @Override
    public Booking save(Booking b) {
        if (b.getId()!=null){
            entityManager.getTransaction().begin();
            b.setBookingDate(b.getBookingDate());
            b.setStatus(b.getStatus());
            entityManager.getTransaction().commit();
            System.out.println("Booking successfully updated");
        }
        else {
            entityManager.getTransaction().begin();
            entityManager.persist(b);
            entityManager.getTransaction().commit();
            System.out.println("Booking successfully added");
        }
        return b;
    }

    @Override
    public Optional<Booking> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Booking.class,id));
    }

    @Override
    public List<Booking> findAll() {
        TypedQuery<Booking> result = entityManager.createQuery("SELECT b from Booking b", Booking.class);
        return result.getResultList();
    }

    @Override
    public Booking delete(Booking b) {
        entityManager.getTransaction().begin();
        entityManager.remove(b);
        entityManager.getTransaction().commit();
        return b;
    }
}
