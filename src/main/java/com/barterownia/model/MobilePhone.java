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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "mobile_phones")
public class MobilePhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String processor;
    private String ram;
    private Float screenSize;
    private String simlock;
    private String color;
    private Boolean isNew;
    private Boolean isWarranty;
    private LocalDate warranty;

}
