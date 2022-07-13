package com.example.BrewingWebApp.demo.controller;

import com.example.BrewingWebApp.demo.model.RawMaterial;
import com.example.BrewingWebApp.demo.model.RecipeDto;
import com.example.BrewingWebApp.demo.model.RecipeIngredient;
import com.example.BrewingWebApp.demo.repository.RawMaterialRepository;
import com.example.BrewingWebApp.demo.repository.RecipeIngredientRepository;
import com.example.BrewingWebApp.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/recipeDto")
public class RecipeController {
    @Autowired
    private RecipeRepository rRepo;

    @Autowired
    private RecipeIngredientRepository ingredientRepository;

    @Autowired
    private RawMaterialRepository rawMaterialRepository;


    @GetMapping({"/listRecipe"})
    public ModelAndView getAllRecipe(){
        ModelAndView mav = new ModelAndView("list-recipes");
        List<RecipeDto> list = rRepo.findAll();
        mav.addObject("recipes", list);
        return mav;
    }

    @GetMapping("/addRecipeForm")
    public ModelAndView addRecipeForm(){
        ModelAndView mav = new ModelAndView("add-recipe-form");
        RecipeDto newRecipeDto = new RecipeDto();
        mav.addObject("recipe", newRecipeDto);
        return mav;
    }
    @PostMapping("/saveRecipe")
    public String saveRecipe(RecipeDto recipe){
        rRepo.save(recipe);
        return "redirect:/recipeDto/listRecipe";
    }

    @GetMapping("/addRecipeIngredients")
    public ModelAndView addRecipeIngredients(@RequestParam Long recipeId){
        ModelAndView mav = new ModelAndView("add-recipe-ingredients-form");
        List<RecipeIngredient> listIngredients = ingredientRepository.findAll();
        List<RawMaterial> rawMaterials = rawMaterialRepository.findAll();
        RecipeDto recipe = rRepo.findById(recipeId).get();

        mav.addObject("listIngredients", listIngredients);
        mav.addObject("rawMaterials", rawMaterials);
        mav.addObject("recipe", recipe);

        RecipeIngredient newIngredient = new RecipeIngredient();
        newIngredient.setRecipeDto(recipe);

        mav.addObject("ingredient",newIngredient);
        return mav;
    }

    @PostMapping("/saveRecipeIngredients")
    public String saveRecipeIngredients(RecipeIngredient ingredient){

        ingredientRepository.save(ingredient);

        return "redirect:/recipeDto/addRecipeIngredients";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long recipeId){
        ModelAndView mav = new ModelAndView("add-recipe-form");
        RecipeDto recipeDto = rRepo.findById(recipeId).get();
        mav.addObject("recipe", recipeDto);
        return mav;
    }
    @GetMapping("/deleteRecipe")
    public String deleteRecipe(@RequestParam Long recipeId){
        rRepo.deleteById(recipeId);
        return "redirect:/recipeDto/listRecipe";
    }

}
