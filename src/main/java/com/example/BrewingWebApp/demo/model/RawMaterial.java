package com.example.BrewingWebApp.demo.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_raw_material")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;


    @OneToMany(targetEntity=RecipeIngredient.class, mappedBy="rawMaterial",
            cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RecipeIngredient> recipeIngredients;


    private String type;
    private String name;
    private String unitMeasure;


    public long getId() {
        return id;
    }

    public Set<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }
}
