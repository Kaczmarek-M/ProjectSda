package com.barterownia.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
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
    private Long ramMb;
    private Long hardDriveMb;
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

        fieldMap.put("Processor", processor);
        fieldMap.put("RAM", ramMb);
        fieldMap.put("Hard Drive", hardDriveMb);
        fieldMap.put("Screen Size", screenSize);
        fieldMap.put("Motherboard", motherboard);
        fieldMap.put("Graphics", graphicsCard);
        fieldMap.put("Date of production", dateOfProduction);
        fieldMap.put("Is new", isNew);
        fieldMap.put("Has Warranty", isWarranty);

        return fieldMap;
    }
}
