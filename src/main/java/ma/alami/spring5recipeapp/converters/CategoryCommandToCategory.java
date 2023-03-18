package ma.alami.spring5recipeapp.converters;

import lombok.Synchronized;
import ma.alami.spring5recipeapp.commands.CategoryCommand;
import ma.alami.spring5recipeapp.domains.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if(source == null) return null;
        final Category category = new Category();
        category.setId(source.getId());
        category.setName(source.getName());
        return category;
    }
}
