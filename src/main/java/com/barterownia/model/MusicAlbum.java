package com.barterownia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "music_album")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MusicAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bandName;
    private String albumName;
    private LocalDate publicationDate;
    private String carrier;

}
