package com.barterownia.model;

import com.barterownia.model.interfaces.AuctionFields;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity(name = "music_album")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MusicAlbum implements AuctionFields {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bandName;
    private String albumName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicationDate;
    private String carrier;

    @Override
    public Map<String, Object> getFieldMap() {

        Map<String, Object> fieldMap = new HashMap<>();

        fieldMap.put("Band name", bandName);
        fieldMap.put("Album name", albumName);
        fieldMap.put("Publication date", publicationDate);
        fieldMap.put("Carrier", carrier);

        return fieldMap;
    }
}
