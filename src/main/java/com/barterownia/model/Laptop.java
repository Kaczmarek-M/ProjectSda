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

    private String processor;
    private Long ramMb;
    private Long hardDriveMb;
    private Float screenSize;
    private String motherboard;
    private String graphicsCard;
    private LocalDate dateOfProduction;
    private Boolean isNew;
    private Boolean isWarranty;

    public Laptop (String name) {this.name = name;}

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", processor='" + processor + '\'' +
                ", ramMb=" + ramMb +
                ", hardDriveMb=" + hardDriveMb +
                ", screenSize=" + screenSize +
                ", motherboard='" + motherboard + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", dateOfProduction=" + dateOfProduction +
                ", isNew=" + isNew +
                ", isWarranty=" + isWarranty +
                '}';
    }
}
