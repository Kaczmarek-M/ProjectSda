package com.barterownia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewLaptopDTO {
    private String name;

    private String processor;
    private Long ramGb;
    private Long hardDriveGb;
    private Float screenSize;
    private String motherboard;
    private String graphicsCard;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfProduction;
    private Boolean isNew;
    private Boolean isWarranty;
}
