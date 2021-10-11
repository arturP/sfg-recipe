package io.artur.spring.tutorial.mvc.sfgrecipe.services;

import io.artur.spring.tutorial.mvc.sfgrecipe.domain.Recipe;
import io.artur.spring.tutorial.mvc.sfgrecipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 *
 */
@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setDescription("This is simple description for recipe");
        recipes.add(recipe1);

        when(recipeRepository.findAll()).thenReturn(recipes);

        Set<Recipe> returnedRecipes = recipeService.getRecipes();

        assertNotNull(returnedRecipes);
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void getRecipesFindById() {
        Long recipeId = 5L;
        Recipe recipe = new Recipe();
        recipe.setId(recipeId);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

        Recipe returnedRecipe = recipeService.findById(recipeId);

        assertNotNull(returnedRecipe);
        verify(recipeRepository, times(1)).findById(anyLong());
    }
}