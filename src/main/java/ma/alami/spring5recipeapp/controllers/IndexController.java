package ma.alami.spring5recipeapp.controllers;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ma.alami.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller @Data @Slf4j
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/","/index","/home"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        log.info("loading index page ...");
        return "index";
    }
}
