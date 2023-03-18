package ma.alami.spring5recipeapp.converters;

import lombok.Synchronized;
import ma.alami.spring5recipeapp.commands.UnitOfMeasureCommand;
import ma.alami.spring5recipeapp.domains.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if(source == null) return null;
        final UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(source.getId());
        unitOfMeasure.setUnit(source.getUnit());
        return unitOfMeasure;
    }
}
