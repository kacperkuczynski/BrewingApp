package com.example.BrewingWebApp.demo.repository;

import com.example.BrewingWebApp.demo.model.RecipeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeDto,Long> {
}
