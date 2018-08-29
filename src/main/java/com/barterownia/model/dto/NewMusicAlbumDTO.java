package com.barterownia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewMusicAlbumDTO {
    private String bandName;
    private String albumName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;
    private String carrier;
}
