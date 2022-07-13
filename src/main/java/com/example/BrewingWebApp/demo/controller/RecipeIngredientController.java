package com.example.BrewingWebApp.demo.controller;

import com.example.BrewingWebApp.demo.model.RawMaterial;
import com.example.BrewingWebApp.demo.model.RecipeIngredient;
import com.example.BrewingWebApp.demo.repository.RawMaterialRepository;
import com.example.BrewingWebApp.demo.repository.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/recipeIngredients")
public class RecipeIngredientController {

    @Autowired
    private RecipeIngredientRepository ingredientRepository;

    @Autowired
    private RawMaterialRepository materialRepository;

    @GetMapping("/list")
    public ModelAndView getAllIngredients(){
        ModelAndView mav = new ModelAndView("list-recipe-ingredients");
        List<RecipeIngredient> listIngredients = ingredientRepository.findAll();
        mav.addObject("listIngredients", listIngredients);
        return mav;
    }

    @GetMapping("/addIngredient")
    public ModelAndView addIngredient(){
        ModelAndView mav = new ModelAndView("add-ingredient");
        RecipeIngredient newIngredient = new RecipeIngredient();
        List<RawMaterial> listMaterials = materialRepository.findAll();
        mav.addObject("ingredient", newIngredient);
        mav.addObject("listMaterials", listMaterials);
        return mav;
    }

    @PostMapping("/saveIngredient")
    public String saveIngredient(@ModelAttribute RecipeIngredient ingredient){
        ingredientRepository.save(ingredient);
        return "redirect:/recipeIngredients/list";
    }



}
