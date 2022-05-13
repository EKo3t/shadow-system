package shadow.system.dictionary

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import shadow.system.dictionary.config.PostgresConfig

@SpringBootApplication(scanBasePackages = ["shadow.system"])
@EnableConfigurationProperties(value = [ PostgresConfig::class ])
open class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}