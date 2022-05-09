package shadow.system.dictionary

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.RequestPredicates.POST
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
open class ApiRouter {

    @Bean
    open fun route() =  
        RouterFunctions.nest(
            POST("/words"),
            RouterFunctions.route(
                POST("/save")
            ) { ServerResponse.ok().body(BodyInserters.fromValue("qq")) }
        )
}