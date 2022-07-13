package com.example.BrewingWebApp.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(targetEntity = RecipeIngredient.class, mappedBy="recipeDto",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RecipeIngredient> listIngredients = new HashSet<>();

    public void setListIngredients(Set<RecipeIngredient> listIngredients) {
        this.listIngredients = listIngredients;
    }

    public Set<RecipeIngredient> getListIngredients() {
        return listIngredients;
    }
//Rozmiar Warki

    private String style;
    private double finalVolume;//oczekiwany rozmiar warki
    private double timeBoiling;//czas gotowania
    private double evaporationRate;//odparowanie
    private double boilingLosses;//straty z gotowania

    private double amountWortBoiled; //ilosc gotowanej brzeczki
    private double preCookingExtract;//Gęstość przed gotowaniem
    private double amountAdjustableWort;//Ilość brzeczki nastawnej
    @Column(name = "date_recipe")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    private String dateRecipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getFinalVolume() {
        return finalVolume;
    }

    public void setFinalVolume(double finalVolume) {
        this.finalVolume = finalVolume;
    }

    public double getTimeBoiling() {
        return timeBoiling;
    }

    public void setTimeBoiling(double timeBoiling) {
        this.timeBoiling = timeBoiling;
    }

    public double getEvaporationRate() {
        return evaporationRate;
    }

    public void setEvaporationRate(double evaporationRate) {
        this.evaporationRate = evaporationRate;
    }

    public double getBoilingLosses() {
        return boilingLosses;
    }

    public void setBoilingLosses(double boilingLosses) {
        this.boilingLosses = boilingLosses;
    }

    public double getAmountWortBoiled() {
        return amountWortBoiled;
    }

    public void setAmountWortBoiled(double amountWortBoiled) {
        this.amountWortBoiled = amountWortBoiled;
    }

    public double getPreCookingExtract() {
        return preCookingExtract;
    }

    public void setPreCookingExtract(double preCookingExtract) {
        this.preCookingExtract = preCookingExtract;
    }

    public double getAmountAdjustableWort() {
        return amountAdjustableWort;
    }

    public void setAmountAdjustableWort(double amountAdjustableWort) {
        this.amountAdjustableWort = amountAdjustableWort;
    }

    public String getDateRecipe() {
        return dateRecipe;
    }

    public void setDateRecipe(String dateRecipe) {
        this.dateRecipe = dateRecipe;
    }
}
