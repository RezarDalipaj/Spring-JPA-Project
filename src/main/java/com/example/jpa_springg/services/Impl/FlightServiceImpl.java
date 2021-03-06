package com.example.jpa_springg.services.Impl;

import com.example.jpa_springg.Repository.FlightRepository.FlightRepository;
import com.example.jpa_springg.model.Flight;
import com.example.jpa_springg.model.User;
import com.example.jpa_springg.services.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flights;
    FlightServiceImpl(FlightRepository flights){
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
