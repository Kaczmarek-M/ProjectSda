package com.barterownia.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "laptop")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String motherboard;
    private String processor;
    private String hardDrive;
    private String RAM;
    private String graphicsCard;
    private LocalDate dateOfProduction;


}