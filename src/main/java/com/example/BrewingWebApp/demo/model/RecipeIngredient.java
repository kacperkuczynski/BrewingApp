package com.example.BrewingWebApp.demo.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;



@Entity
@Table(name = "tbl_recipe_ingredient")
@Data
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @ManyToOne(targetEntity = RecipeDto.class)
    @JoinColumn(name = "recipe_dto_id")
    private RecipeDto recipeDto;

    @ManyToOne(targetEntity = RawMaterial.class)
    @JoinColumn(name = "raw_material_id")
    @Type(type = "id")
    private RawMaterial rawMaterial;


    private int amount;

    public RecipeIngredient(Long id, RecipeDto recipeDto, RawMaterial rawMaterial, int amount) {
        this.id = id;
        this.recipeDto = recipeDto;
        this.rawMaterial = rawMaterial;
        this.amount = amount;
    }


    public RecipeIngredient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RecipeDto getRecipeDto() {
        return recipeDto;
    }

    public void setRecipeDto(RecipeDto recipeDto) {
        this.recipeDto = recipeDto;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
