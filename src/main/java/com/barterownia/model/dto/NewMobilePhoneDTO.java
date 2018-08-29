package com.barterownia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewMobilePhoneDTO {
    private String name;

    private String processor;
    private Long ramGb;
    private Float screenSize;
    private String simlock;
    private String color;
    private Boolean isNew;
    private Boolean isWarranty;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate warranty;
}
