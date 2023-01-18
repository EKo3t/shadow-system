package shadow.dictionary.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import shadow.dictionary.api.model.Word;
import shadow.dictionary.service.WordService;

@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> route(WordService service) {
        return RouterFunctions
            .route(RequestPredicates.POST("/save"),
                request -> request.bodyToMono(Word.class)
                    .flatMap(service::save)
                    .flatMap(void_ -> ServerResponse.ok().build()));
    }
}
