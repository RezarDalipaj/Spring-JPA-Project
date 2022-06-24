package com.example.jpa_springg.Repository.BookingRepository;
import com.example.jpa_springg.model.Booking;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
public interface BookingRepository {
    public Booking save(Booking b);
    public Optional<Booking> findById(Integer id);
    public List<Booking> findAll();
    public Booking delete(Booking b);
}
