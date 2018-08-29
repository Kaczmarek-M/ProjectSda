package com.barterownia.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewVideoGameDTO {
    private String title;
    private String genre;
    private String platform;
    private String publisher;
    private Boolean isNew;
    private Integer pegi;
}
