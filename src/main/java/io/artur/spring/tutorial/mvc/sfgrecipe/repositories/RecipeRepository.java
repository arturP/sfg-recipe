package io.artur.spring.tutorial.mvc.sfgrecipe.repositories;

import io.artur.spring.tutorial.mvc.sfgrecipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


/**
 *
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
