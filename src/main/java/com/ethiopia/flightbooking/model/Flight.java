package com.ethiopia.flightbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String flightnr;

    @NotNull
    @Future
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-dd-MM")
    private Date departureDate;

    @NotNull
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date departureTime;

    @NotNull
    @Future
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-dd-MM")
    private Date arrivalDate;

    @NotNull
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date arrivalTime;


    @ManyToOne
    private Airline airline;

    @ManyToOne
    private Airport origin;


    @ManyToOne
    private Airport destination;


    @ManyToOne
    private Airplane airplane;


    @OneToMany
    private List<Booking> bookings;


}
