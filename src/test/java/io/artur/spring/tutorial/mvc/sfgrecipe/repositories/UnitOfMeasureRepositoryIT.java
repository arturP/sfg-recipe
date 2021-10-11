package io.artur.spring.tutorial.mvc.sfgrecipe.repositories;

import io.artur.spring.tutorial.mvc.sfgrecipe.domain.UnitOfMeasure;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void findByDescription() throws Exception {

        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (uom.isEmpty()) {
            fail("Expected not empty result!");
        }
        assertEquals("Teaspoon", uom.get().getDescription());
    }
}
