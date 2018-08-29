package com.barterownia.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class ContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;
    private String phoneNumber;
    private String zipCode;
    private String city;
    private String street;
    private String home;

    public ContactDetails() {
    }

    public ContactDetails(String email) {
        this.email = email;
    }
}
