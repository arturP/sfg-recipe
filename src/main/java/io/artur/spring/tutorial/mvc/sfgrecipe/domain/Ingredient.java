package io.artur.spring.tutorial.mvc.sfgrecipe.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 *
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unit;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unit) {
        this.description = description;
        this.amount = amount;
        this.unit = unit;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unit, Recipe recipe) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.unit = unit;
        this.recipe = recipe;
    }

}
