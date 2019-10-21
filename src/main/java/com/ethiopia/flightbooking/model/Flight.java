package com.ethiopia.flightbooking.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flights")
public class Flight
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer flightId;

    @Column(name = "flightnumber")
    private String flightNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airline airline;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airport origin;

    @ManyToOne(cascade = CascadeType.ALL)
    private Airport destination;

    @ManyToOne(cascade = CascadeType.ALL) // Many flights can have the same airplane multiplexed by time.
    private Airplane airplane;

    @Column(name = "dateofflight")
    private LocalDate dateOfFlight;

    @Column(name = "departuretime")
    private LocalTime departureTime;

    @Column(name = "arrivaltime")
    private LocalTime arrivalTime;





}
