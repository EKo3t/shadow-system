package shadow.system.dictionary

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["shadow.system"])
open class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}