package com.example.rentacarspr.concretes;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Table(name = "cars")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    Integer id;
    @Column(name = "plate",unique = true)
    String plate;
    @Column(name = "dailyPrice")
    Double dailyPrice;
    @Column(name = "modelYear")
    Integer modelYear;
    @Column(name = "state")
    Integer state;
    @ManyToOne
    @JoinColumn(name = "model_id")
    Model model;


}
