package io.artur.spring.tutorial.mvc.sfgrecipe.services;

import io.artur.spring.tutorial.mvc.sfgrecipe.domain.Recipe;

import java.util.Set;

/**
 *
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long id);
}
