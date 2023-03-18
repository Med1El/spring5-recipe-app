package ma.alami.spring5recipeapp.converters;

import lombok.Synchronized;
import ma.alami.spring5recipeapp.commands.NotesCommand;
import ma.alami.spring5recipeapp.domains.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if(source == null) return null;
        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setNotes(source.getNotes());
        return notes;
    }
}
