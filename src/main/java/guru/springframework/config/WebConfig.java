package guru.springframework.config;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class WebConfig
{
//    show json on page
    @Bean
    public RouterFunction<?> routes(RecipeService recipeService){
        return RouterFunctions.route(RequestPredicates.GET("/api/recipes"),
                serverRequest -> ServerResponse.ok().
                        contentType(MediaType.APPLICATION_JSON).
                        body(recipeService.getRecipes(),Recipe.class));
    }
}
