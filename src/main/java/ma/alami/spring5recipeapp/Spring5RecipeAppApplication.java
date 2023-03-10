package ma.alami.spring5recipeapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@Slf4j
public class Spring5RecipeAppApplication {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Spring5RecipeAppApplication.class, args);
    }

}
