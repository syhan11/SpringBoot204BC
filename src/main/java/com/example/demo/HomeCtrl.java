package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeCtrl {
    @GetMapping("/tvform")
    // passes empty tvshow object to "tvform"
    public String loadTvForm(Model model) {
        model.addAttribute("tvshow", new Tvshow());
        return "tvform";
    }

    @PostMapping("/tvform")
    // passes validated tvshow object to tvshowconfirm
    // otherwise it shoes error on tvform
    public String processTvForm(@Valid Tvshow tvshow, BindingResult result){
        if (result.hasErrors()) {
            return "tvform";
        }
        return "tvshowconfirm";
    }
}
