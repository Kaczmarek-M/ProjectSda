package com.barterownia.model;

import com.barterownia.model.interfaces.AuctionFields;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Entity(name = "video_game")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VideoGame implements AuctionFields {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String genre;
    private String platform;
    private String publisher;
    private Boolean isNew;
    private Integer pegi;


    @Override
    public Map<String, Object> getFieldMap() {
        Map<String, Object> fieldMap = new HashMap<>();

        fieldMap.put("Gra", title);
        fieldMap.put("Rodzaj", genre);
        fieldMap.put("Platforma", platform);
        fieldMap.put("Wydawca", publisher);
        fieldMap.put("Czy jest nowa?", isNew);
        fieldMap.put("Pegi", pegi);

        return fieldMap;
    }
}