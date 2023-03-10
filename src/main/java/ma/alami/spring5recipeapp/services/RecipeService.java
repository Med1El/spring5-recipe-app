package ma.alami.spring5recipeapp.services;

import ma.alami.spring5recipeapp.domains.Recipe;

import java.util.Set;

public interface RecipeService {

    public Set<Recipe> getRecipes();

}
