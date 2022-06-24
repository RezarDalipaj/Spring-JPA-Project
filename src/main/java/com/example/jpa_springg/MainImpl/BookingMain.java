package com.example.jpa_springg.MainImpl;

import com.example.jpa_springg.model.Booking;
import com.example.jpa_springg.model.Flight;
import com.example.jpa_springg.model.User;
import com.example.jpa_springg.services.BookingService.BookingServiceImpl;
import com.example.jpa_springg.services.FlightService.FlightServiceImpl;
import com.example.jpa_springg.services.UserService.UserServiceImpl;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.*;

@Component
public class BookingMain {
    BookingServiceImpl booking;
    UserServiceImpl user;
    FlightServiceImpl flight;

    public BookingMain(BookingServiceImpl booking, UserServiceImpl user, FlightServiceImpl flight) {
        this.booking = booking;
        this.user = user;
        this.flight = flight;
    }


    public void find(){
//        BookingService booking = new BookingService();
        List<Booking> bookingList = booking.findAll();
        System.out.println("All the bookings...\n");
        for (Booking b : bookingList) {
            System.out.println(b);
        }
    }
    public Booking add(){
        Scanner read = new Scanner(System.in);
//        BookingService booking = new BookingService();
        Integer id = 0;
        System.out.println("\nAdding booking\n");
        System.out.println("Enter the booking id");
        try {
            id = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        System.out.println("Enter the id of the user who booked the flight");
        int uId = read.nextInt();
//        UserService user = new UserService();
        Optional<User> userById = user.findById(uId);
        System.out.println("The flights of this booking...");
        int result = 0;
//        FlightService flight = new FlightService();
        List<Flight> flights = new ArrayList<>();
        while (result != -1){
            System.out.println("Add one flight id to this booking (-1 to stop)");
            try {
                result = read.nextInt();
                read.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Id should be a number");
                read.nextLine();
            }
            Optional<Flight> flightById = flight.findById(result);
            if (flightById.isPresent()){
                Flight fbyId = flightById.get();
                flights.add(fbyId);
            }
            else if (result != -1){
                System.out.println("This flight doesnt exist");
                return null;
            }
        }
        if (userById.isPresent()){
            User ubyId = userById.get();
            Date date = new Date(System.currentTimeMillis());
            System.out.println("Enter the status");
            String status = read.nextLine();
            Optional<Booking> bookingById = booking.findById(id);
            if (bookingById.isPresent()){
                Booking b1 = bookingById.get();
                b1.setStatus(status);
                b1.setBookingDate(date);
                b1.setUser(ubyId);
                b1.setFlights(flights);
                booking.save(b1);
                return b1;
            }
            else {
                Booking b2 = new Booking();
                b2.setId(null);
                b2.setStatus(status);
                b2.setBookingDate(date);
                b2.setUser(ubyId);
                b2.setFlights(flights);
                booking.save(b2);
                return b2;
            }
        }
        else {
            System.out.println("Couldnt add booking. Invalid user");
            return null;
        }
    }
    public void findId(){
        Scanner read = new Scanner(System.in);
//        BookingService booking = new BookingService();
        Integer find = 0;
        System.out.println("\nFinding booking by id\n");
        try {
            System.out.println("Enter the booking id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Booking> booking1 = booking.findById(find);
        if (booking1.isPresent()){
            Booking byId = booking1.get();
            System.out.println(byId);
        }
        else
            System.out.println("This booking doesnt exist");
    }
    public void remove(){
        Integer find = 0;
        Scanner read = new Scanner(System.in);
//        BookingService booking = new BookingService();
        System.out.println("\nDeleting booking\n");
        try {
            System.out.println("Enter the booking id you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Booking> booking2 = booking.findById(find);
        if (booking2.isPresent()){
            Booking bdelete = booking2.get();
            booking.delete(bdelete);
        }
        else
            System.out.println("This booking doesnt exist");
    }
}
