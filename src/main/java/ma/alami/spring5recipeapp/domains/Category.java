package ma.alami.spring5recipeapp.domains;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;


}
