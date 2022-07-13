package com.example.BrewingWebApp.demo.controller;

import com.example.BrewingWebApp.demo.model.Bottling;
import com.example.BrewingWebApp.demo.repository.BottlingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/bottling")
public class BottlingController {
    @Autowired
    BottlingRepository bottlingRepository;

    @GetMapping({"/listBottling"})
    public ModelAndView showMaltHouse(){
        ModelAndView mav = new ModelAndView("list-bottling");
        List<Bottling> list = bottlingRepository.findAll();
        mav.addObject("bottles", list);
        return mav;
    }

    @GetMapping({"/addBottlingForm"})
    public ModelAndView addMaltForm(){
        ModelAndView mav = new ModelAndView("add-bottling-form");
        Bottling newBottling = new Bottling();
        mav.addObject("bottle", newBottling);
        return mav;
    }
    @PostMapping({"/saveBottling"})
    public String saveMalt(@ModelAttribute Bottling bottle){
        bottlingRepository.save(bottle);
        return "redirect:/bottling/listBottling";
    }
    @GetMapping({"/updateDetails"})
    public ModelAndView showUpdateForm(@RequestParam Long bottlingId){
        ModelAndView mav = new ModelAndView("add-bottling-form");
        Bottling bottle = bottlingRepository.findById(bottlingId).get();
        mav.addObject("bottle", bottle);
        return mav;
    }
    @GetMapping({"/updateAmountBottling"})
    public ModelAndView showUpdateAmount(@RequestParam Long bottlingId){
        ModelAndView mav = new ModelAndView("update-amount-bottling");
        Bottling bottle = bottlingRepository.findById(bottlingId).get();
        mav.addObject("bottle", bottle);
        return mav;
    }

    @GetMapping({"/deleteBottling"})
    public String deleteMalt(@RequestParam Long bottlingId){
        bottlingRepository.deleteById(bottlingId);
        return "redirect:/bottling/listBottling";
    }
}
