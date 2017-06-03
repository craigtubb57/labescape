package com.craigtubb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.craigtubb.exception.NoEscapeException;

@Controller
public class LabEscapeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String labForm(Model model) {
        model.addAttribute("labToEscape", new LabToEscape());
        return "lab_to_escape";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String labSubmit(@ModelAttribute LabToEscape toEscape) {
        try {
            Escaper.escape(toEscape);
        } catch (NoEscapeException e) {
            return "no_escape";
        }
        return "escape";
    }
}