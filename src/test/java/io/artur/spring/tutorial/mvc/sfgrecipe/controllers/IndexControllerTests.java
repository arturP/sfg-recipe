package io.artur.spring.tutorial.mvc.sfgrecipe.controllers;

import io.artur.spring.tutorial.mvc.sfgrecipe.domain.Recipe;
import io.artur.spring.tutorial.mvc.sfgrecipe.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 *
 */
@ExtendWith(MockitoExtension.class)
public class IndexControllerTests {
    private IndexController indexController;

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        indexController = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception{

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndexPageReturnsIndex() {
        String expectedResult = "index";
        Set<Recipe> recipes = new HashSet<>();

        when(recipeService.getRecipes()).thenReturn(recipes);
        when(model.addAttribute(any(), any())).thenReturn(model);

        String result = indexController.getIndexPage(model);

        assertEquals(expectedResult, result);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(any(), any());
    }
}
