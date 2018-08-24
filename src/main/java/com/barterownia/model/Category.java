package com.barterownia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String tableName;


}
