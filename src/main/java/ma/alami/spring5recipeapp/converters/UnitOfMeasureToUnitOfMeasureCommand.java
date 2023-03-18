package ma.alami.spring5recipeapp.converters;

import lombok.Synchronized;
import ma.alami.spring5recipeapp.commands.UnitOfMeasureCommand;
import ma.alami.spring5recipeapp.domains.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if(source == null) return null;
        final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(source.getId());
        unitOfMeasureCommand.setUnit(source.getUnit());
        return unitOfMeasureCommand;
    }
}
