package com.example.jpa_springg.services;

import com.example.jpa_springg.Repository.FlightRepository.FlightRepository;
import com.example.jpa_springg.Repository.FlightRepository.FlightRepositoryImpl;
import com.example.jpa_springg.model.Flight;
import com.example.jpa_springg.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class FlightService {
    private FlightRepository flights;
    FlightService(FlightRepository flights){
        this.flights = flights;
    }
//    FlightRepository flights = new FlightRepositoryImpl();
    public Flight save(Flight f){
        return flights.save(f);
    }
    public Optional<Flight> findById(Integer id){
        return flights.findById(id);
    }
    public List<Flight> findAll(){
        return flights.findAll();
    }
    public Flight delete(Flight f){
        return flights.delete(f);
    }
    public List<User> allUsers(int x){return flights.allUsers(x);}
}
