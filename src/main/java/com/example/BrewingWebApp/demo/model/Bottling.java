package com.example.BrewingWebApp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_bottling")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bottling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long tankNumber;
    private String style;
    private float startAmount;
    private float stayed;
    private boolean reset;
}
