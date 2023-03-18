package ma.alami.spring5recipeapp.converters;

import ma.alami.spring5recipeapp.commands.RecipeCommand;
import ma.alami.spring5recipeapp.domains.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private NotesToNotesCommand notesToNotesCommand;
    private IngredientToIngredientCommand ingredientToIngredientCommand;
    private CategoryToCategoryCommand categoryToCategoryCommand;


    @Override
    public RecipeCommand convert(Recipe source) {
        if(source == null) return null;
        final RecipeCommand target = new RecipeCommand();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        target.setPrepTime(source.getPrepTime());
        target.setCookTime(source.getCookTime());
        target.setServings(source.getServings());
        target.setSource(source.getSource());
        target.setDifficulty(source.getDifficulty());
        target.setNotes(notesToNotesCommand.convert(source.getNotes()));
        target.setIngredients(source.getIngredients().stream().map(ingredientToIngredientCommand::convert).collect(Collectors.toSet()));
        target.setCategories(source.getCategories().stream().map(categoryToCategoryCommand::convert).collect(Collectors.toSet()));
        return target;
    }
}
