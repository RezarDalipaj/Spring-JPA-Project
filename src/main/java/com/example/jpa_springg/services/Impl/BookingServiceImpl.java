package com.example.jpa_springg.services.Impl;

import com.example.jpa_springg.Repository.BookingRepository.BookingRepository;
import com.example.jpa_springg.model.Booking;
import com.example.jpa_springg.services.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookings;
    public BookingServiceImpl(BookingRepository bookings) {
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
