package ma.alami.spring5recipeapp.repositories;

import lombok.extern.slf4j.Slf4j;
import ma.alami.spring5recipeapp.domains.UnitOfMeasure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeAll
    static void beforeAll() {
        log.warn("integration test started ...");
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void findTeaspoon() {
        Optional<UnitOfMeasure> unit = unitOfMeasureRepository.findByUnit("Teaspoon");
        assertEquals("Teaspoon", unit.get().getUnit());
    }

    @Test
    void findCup() {
        Optional<UnitOfMeasure> unit = unitOfMeasureRepository.findByUnit("Cup");
        assertEquals("Cup", unit.get().getUnit());
    }

}