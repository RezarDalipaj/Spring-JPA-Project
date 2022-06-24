package com.example.jpa_springg.Repository.FlightRepository.impl;

import com.example.jpa_springg.Repository.FlightRepository.FlightRepository;
import com.example.jpa_springg.config.EntityManagerConfig;
import com.example.jpa_springg.model.Flight;
import com.example.jpa_springg.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
@Component
public class FlightRepositoryImpl implements FlightRepository {
    private EntityManager entityManager = EntityManagerConfig.getEntityManager();
    @Override
    public Flight save(Flight f) {
        if (f.getId()!=null){
            entityManager.getTransaction().begin();
            f.setOrigin(f.getOrigin());
            f.setDestination(f.getDestination());
            f.setArrivalDate(f.getArrivalDate());
            f.setDepartureDate(f.getDepartureDate());
            f.setFlightNumber(f.getFlightNumber());
            f.setAirline(f.getAirline());
            f.setStatus(f.getStatus());
            entityManager.getTransaction().commit();
            System.out.println("Flight successfully updated");
        }
        else {
            entityManager.getTransaction().begin();
            entityManager.persist(f);
            entityManager.getTransaction().commit();
            System.out.println("Flight successfully added");
        }
        return f;
    }

    @Override
    public Optional<Flight> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Flight.class, id));
    }

    @Override
    public List<Flight> findAll() {
        TypedQuery<Flight> result = entityManager.createQuery("SELECT f from Flight f", Flight.class);
        return result.getResultList();
    }

    @Override
    public Flight delete(Flight f) {
        entityManager.getTransaction().begin();
        entityManager.remove(f);
        entityManager.getTransaction().commit();
        return f;
    }

    @Override
    public List<User> allUsers(int x) {
//        TypedQuery<User> query = entityManager.createNamedQuery("usersOfAFlight",User.class);
//        query.setParameter("flightId", x);
//        return query.getResultList();
        return null;
    }
}
