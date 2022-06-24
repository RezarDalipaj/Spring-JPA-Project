package com.example.jpa_springg.services;

import com.example.jpa_springg.Repository.BookingRepository.BookingRepository;
import com.example.jpa_springg.Repository.BookingRepository.BookingRepositoryImpl;
import com.example.jpa_springg.Repository.UserRepository.UserRepository;
import com.example.jpa_springg.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Component
public class BookingService {
    private BookingRepository bookings;
    public BookingService(BookingRepository bookings) {
        this.bookings = bookings;
    }

    public Booking save(Booking b){
        return bookings.save(b);
    }
    public Optional<Booking> findById(Integer id){
        return bookings.findById(id);
    }
    public List<Booking> findAll(){
        return bookings.findAll();
    }
    public Booking delete(Booking u){
        return bookings.delete(u);
    }


}
