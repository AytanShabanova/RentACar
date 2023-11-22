package com.example.rentacarspr.concretes;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


import java.util.List;

@Table(name = "brands")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Brand {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
   private Integer id;
    @Column(name ="name")
    private String name;
    @OneToMany(mappedBy = "brand")
    List<Model>models;
}