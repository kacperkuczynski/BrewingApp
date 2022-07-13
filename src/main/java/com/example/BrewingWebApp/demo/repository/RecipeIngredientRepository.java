package com.example.BrewingWebApp.demo.repository;

import com.example.BrewingWebApp.demo.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}
