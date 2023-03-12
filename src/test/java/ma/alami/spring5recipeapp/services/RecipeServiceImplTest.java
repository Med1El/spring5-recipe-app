package ma.alami.spring5recipeapp.services;

import ma.alami.spring5recipeapp.domains.Recipe;
import ma.alami.spring5recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipesMock = new HashSet<>();
        recipesMock.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesMock);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(1, recipes.size());

        verify(recipeRepository, times(1)).findAll();

    }
}