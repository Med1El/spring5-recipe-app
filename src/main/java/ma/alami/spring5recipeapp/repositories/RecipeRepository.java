package ma.alami.spring5recipeapp.repositories;

import ma.alami.spring5recipeapp.domains.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
