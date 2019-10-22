package com.ethiopia.flightbooking.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airline airline;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airport origin;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Airport destination;

    @ManyToOne(cascade = CascadeType.PERSIST) // Many flights can have the same airplane multiplexed by time.
    private Airplane airplane;

    @Column(name = "departuredate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @Column(name = "arrivaldate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;


    @Column(name = "departuretime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime departureTime;

    @Column(name = "arrivaltime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime arrivalTime;

    @Column(name = "fare")
    private Double fare;


}
