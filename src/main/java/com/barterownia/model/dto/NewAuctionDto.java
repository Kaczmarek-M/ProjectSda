package com.barterownia.model.dto;

import com.barterownia.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewAuctionDto {

    private String title;

    private String description;

    private int duration;

    private Item item;
}
