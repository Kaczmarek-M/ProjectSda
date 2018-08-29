package com.barterownia.model;


import com.barterownia.model.interfaces.AuctionFields;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity(name = "laptop")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Laptop implements AuctionFields {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;

    private String processor;
    private Long ramGb;
    private Long hardDriveGb;
    private Float screenSize;
    private String motherboard;
    private String graphicsCard;

    @DateTimeFormat(pattern = "yyyy-dd-MM")
    private LocalDate dateOfProduction;
    private Boolean isNew;
    private Boolean isWarranty;

    public Laptop(String name) {
        this.name = name;
    }


    @Override
    public Map<String, Object> getFieldMap() {
        Map<String, Object> fieldMap = new HashMap<>();

        fieldMap.put("Procesor", processor);
        fieldMap.put("Pamięć ram", ramGb + " " + "Gb");
        fieldMap.put("Dysk twardy", hardDriveGb +" "+ "Gb");
        fieldMap.put("Rozmiar ekranu", screenSize);
        fieldMap.put("Płyta główna", motherboard);
        fieldMap.put("Karta graficzna", graphicsCard);
        fieldMap.put("Data produkcji", dateOfProduction);
        fieldMap.put("Czy jest nowy?", isNew);
        fieldMap.put("Czy ma gwarancje?", isWarranty);

        return fieldMap;
    }
}
