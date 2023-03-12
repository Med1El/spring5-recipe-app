package ma.alami.spring5recipeapp.bootstrap;

import lombok.extern.slf4j.Slf4j;
import ma.alami.spring5recipeapp.domains.*;
import ma.alami.spring5recipeapp.repositories.CategoryRepository;
import ma.alami.spring5recipeapp.repositories.RecipeRepository;
import ma.alami.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;

@Transactional
@Slf4j
@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UnitOfMeasureRepository unitOfMeasureRepository;
    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;

    public DataBootstrap(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Recipe guacamole = new Recipe();
        guacamole.setDescription("Best Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setServings(3);
        guacamole.setSource("simplyrecipes");
        guacamole.setUrl("simplyrecipes.com/recipes/perfect_guacamole/");

        guacamole.setDifficulty(Difficulty.Easy);

        Notes guacaNotes = new Notes();
        guacaNotes.setNotes("Be careful handling chilis! If using, it's best to wear food-safe gloves. If no gloves are available, wash your hands thoroughly after handling, and do not touch your eyes or the area near your eyes for several hours afterwards\n" +
                "Chilling tomatoes hurts their flavor. So, if you want to add chopped tomato to your guacamole, add it just before serving");

        guacaNotes.setRecipe(guacamole);
        guacamole.setNotes(guacaNotes);


        UnitOfMeasure eachUom = unitOfMeasureRepository.findByUnit("Each").orElseThrow();
        UnitOfMeasure teaspoon = unitOfMeasureRepository.findByUnit("Teaspoon").orElseThrow();
        UnitOfMeasure tablespoon = unitOfMeasureRepository.findByUnit("Tablespoon").orElseThrow();
        UnitOfMeasure pinchUom = unitOfMeasureRepository.findByUnit("Pinch").orElseThrow();

        Ingredient avocado = new Ingredient("ripe avocado",new BigDecimal(2), eachUom);
        Ingredient salt = new Ingredient("kosher salt, plus more to taste",new BigDecimal(0.25), teaspoon);
        Ingredient lemon = new Ingredient("fresh lime or lemon juice", new BigDecimal(1), tablespoon);
        Ingredient onion = new Ingredient(" minced red onion or thinly sliced green onion", new BigDecimal(3), tablespoon);
        Ingredient chili = new Ingredient("serrano (or jalapeño) chilis, stems and seeds removed, minced", new BigDecimal(1), eachUom);
        Ingredient cilantro = new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tablespoon);
        Ingredient pepper = new Ingredient("freshly ground black pepper", new BigDecimal(1), pinchUom);
        Ingredient tomato = new Ingredient("ripe tomato, chopped (optional)", new BigDecimal(0.5), eachUom);
        Ingredient radish = new Ingredient("Red radish or jicama slices for garnish (optional)", new BigDecimal(1), eachUom);

        guacamole.getIngredients().add(avocado);
        guacamole.getIngredients().add(salt);
        guacamole.getIngredients().add(lemon);
        guacamole.getIngredients().add(onion);
        guacamole.getIngredients().add(chili);
        guacamole.getIngredients().add(cilantro);
        guacamole.getIngredients().add(pepper);
        guacamole.getIngredients().add(tomato);
        guacamole.getIngredients().add(radish);

        avocado.setRecipe(guacamole);
        salt.setRecipe(guacamole);
        lemon.setRecipe(guacamole);
        onion.setRecipe(guacamole);
        chili.setRecipe(guacamole);
        cilantro.setRecipe(guacamole);
        pepper.setRecipe(guacamole);
        tomato.setRecipe(guacamole);
        radish.setRecipe(guacamole);

        Category mexican = categoryRepository.findByName("Mexican").orElseThrow();
        guacamole.getCategories().add(mexican);
        
        recipeRepository.save(guacamole);

        log.info("bootstrapping executed");
    }
}
