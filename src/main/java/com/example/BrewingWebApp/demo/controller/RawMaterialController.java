package com.example.BrewingWebApp.demo.controller;

import com.example.BrewingWebApp.demo.model.RawMaterial;
import com.example.BrewingWebApp.demo.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rawMaterial")
public class RawMaterialController {
    @Autowired
    RawMaterialRepository rawMaterialRepository;

    @GetMapping({"/list"})
    public ModelAndView showMaltHouse(){
        ModelAndView mav = new ModelAndView("list-raw-materials");
        List<RawMaterial> list = rawMaterialRepository.findAll();
        mav.addObject("materials", list);
        return mav;
    }

    @GetMapping({"/addRawMaterialForm"})
    public ModelAndView addRawMaterialForm(){
        ModelAndView mav = new ModelAndView("add-raw-material-form");
        RawMaterial newRawMaterial = new RawMaterial();
        mav.addObject("material", newRawMaterial);
        return mav;
    }
    @PostMapping({"/saveRawMaterial"})
    public String saveMalt(@ModelAttribute RawMaterial material){
        rawMaterialRepository.save(material);
        return "redirect:/rawMaterial/list";
    }
    @GetMapping({"/updateDetails"})
    public ModelAndView showUpdateForm(@RequestParam Long materialId){
        ModelAndView mav = new ModelAndView("add-raw-material-form");
        RawMaterial RawMaterial = rawMaterialRepository.findById(materialId).get();
        mav.addObject("material", RawMaterial);
        return mav;
    }

    @GetMapping({"/deleteRawMaterial"})
    public String deleteMalt(@RequestParam Long materialId){
        rawMaterialRepository.deleteById(materialId);
        return "redirect:/rawMaterial/list";
    }
}
