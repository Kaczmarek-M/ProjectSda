package com.barterownia.model.dto;

import com.barterownia.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewAuctionDTO {

    private String title;

    private String description;

    private Integer duration;

    private long estimatedPrice;

    private long categoryId;
}
