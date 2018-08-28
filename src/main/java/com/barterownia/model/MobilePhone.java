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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "mobile_phone")
public class MobilePhone implements AuctionFields {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String processor;
    private Long ramMb;
    private Float screenSize;
    private String simlock;
    private String color;
    private Boolean isNew;
    private Boolean isWarranty;
    private LocalDate warranty;

    public MobilePhone(String name) {
        this.name = name;
    }


    @Override
    public Map<String, Object> getFieldMap() {
        Map<String, Object> fieldMap = new HashMap<>();

        fieldMap.put("Processor", processor);
        fieldMap.put("RAM", ramMb);
        fieldMap.put("Screen Size", screenSize);
        fieldMap.put("Simlock", simlock);
        fieldMap.put("Color", color);
        fieldMap.put("Warranty date", warranty);
        fieldMap.put("Is new", isNew);
        fieldMap.put("Has Warranty", isWarranty);

        return fieldMap;
    }
}
