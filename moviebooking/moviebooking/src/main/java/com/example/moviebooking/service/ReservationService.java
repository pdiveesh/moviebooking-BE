package com.example.moviebooking.service;

import com.example.moviebooking.model.Reservation;
import com.example.moviebooking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(String id) {
        return reservationRepository.findById(id);
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(String id, Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation.setDate(reservationDetails.getDate());
        reservation.setStartAt(reservationDetails.getStartAt());
        reservation.setSeats(reservationDetails.getSeats());
        reservation.setOrderId(reservationDetails.getOrderId());
        reservation.setTicketPrice(reservationDetails.getTicketPrice());
        reservation.setTotal(reservationDetails.getTotal());
        reservation.setMovieId(reservationDetails.getMovieId());
        reservation.setTheatreId(reservationDetails.getTheatreId());
        reservation.setName(reservationDetails.getName());
        reservation.setPhone(reservationDetails.getPhone());
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }
}
