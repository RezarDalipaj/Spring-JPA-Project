package com.example.jpa_springg.services.FlightService;

import com.example.jpa_springg.model.Flight;
import com.example.jpa_springg.model.User;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    public Flight save(Flight f);
    public Optional<Flight> findById(Integer id);
    public List<Flight> findAll();
    public Flight delete(Flight f);
    public List<User> allUsers(int x);
}
