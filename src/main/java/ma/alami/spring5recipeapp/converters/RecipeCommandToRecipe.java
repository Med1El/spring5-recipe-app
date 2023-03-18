package ma.alami.spring5recipeapp.converters;

import ma.alami.spring5recipeapp.commands.RecipeCommand;
import ma.alami.spring5recipeapp.domains.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private NotesCommandToNotes notesCommandToNotes;
    private IngredientCommandToIngredient ingredientCommandToIngredient;
    private CategoryCommandToCategory categoryCommandToCategory;


    @Override
    public Recipe convert(RecipeCommand source) {
        if(source == null) return null;
        final Recipe target = new Recipe();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        target.setPrepTime(source.getPrepTime());
        target.setCookTime(source.getCookTime());
        target.setServings(source.getServings());
        target.setSource(source.getSource());
        target.setDifficulty(source.getDifficulty());
        target.setNotes(notesCommandToNotes.convert(source.getNotes()));
        target.setIngredients(source.getIngredients().stream().map(ingredientCommandToIngredient::convert).collect(Collectors.toSet()));
        target.setCategories(source.getCategories().stream().map(categoryCommandToCategory::convert).collect(Collectors.toSet()));
        return target;
    }
}
