package com.craigtubb.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.craigtubb.exception.NoEscapeException;
import com.craigtubb.labescape.Escaper;
import com.craigtubb.labescape.LabToEscape;

@Controller
public class LabEscapeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String labForm(Model model) {
        model.addAttribute("labToEscape", new LabToEscape());
        return "lab_to_escape";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String labSubmit(@Valid @ModelAttribute LabToEscape toEscape, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "lab_to_escape";
        }

        try {
            Escaper.escape(toEscape);
        } catch (NoEscapeException | ArrayIndexOutOfBoundsException e) {
            return "no_escape";
        }

        return "escape";
    }
}