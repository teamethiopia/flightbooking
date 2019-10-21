package com.ethiopia.flightbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="airplane")
@ToString
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String serialNumber;

    @NotEmpty
    private String model;

    @Range(min = 0, max = 853)
    private int capacity;

    @JsonIgnore
    @OneToMany(mappedBy = "airplane")
    @OrderBy("departureDate, departureTime")
    private List<Flight> flights;

}