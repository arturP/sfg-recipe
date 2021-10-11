package io.artur.spring.tutorial.mvc.sfgrecipe.controllers;

import io.artur.spring.tutorial.mvc.sfgrecipe.services.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Slf4j
@AllArgsConstructor
@Controller
public class RecipeController {

    private final RecipeService service;
    private static final String TEMPLATE_NAME = "recipe/show";

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", service.findById(Long.parseLong(id)));

        return TEMPLATE_NAME;
    }
}
