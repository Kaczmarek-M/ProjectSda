package com.barterownia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VideoGame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String Platform;
    private String Genre;
    private Double Price;
    private boolean isNew;
    private int Pegi;
    private String publishingVersion;
    private String OS;

}