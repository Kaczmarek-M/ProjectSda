package com.barterownia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewLaptopDTO {
    private String name;

    private String processor;
    private Long ramMb;
    private Long hardDriveMb;
    private Float screenSize;
    private String motherboard;
    private String graphicsCard;
    private LocalDate dateOfProduction;
    private Boolean isNew;
    private Boolean isWarranty;
}
