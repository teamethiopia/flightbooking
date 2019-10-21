package com.ethiopia.flightbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "airport")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String airportCode;


    @NotEmpty
    private String city;

    @NotEmpty
    private String country;
    @NotEmpty
    private String airportName;

    @OneToMany(mappedBy = "destination")
    @OrderBy("arrivalDate, arrivalTime")
    List<Flight> arrivals;

    @OneToMany(mappedBy = "origin")
    @OrderBy("departureDate, departureTime")
    List<Flight> departures;


}
