package shadow.system.dictionary.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.PropertySource

@ConfigurationProperties(prefix = "connection")
@PropertySource("classpath:postgres-config.properties")
@ConstructorBinding
open class PostgresConfig(
    val username: String?,
    val password: String?,
    val url: String?,
    val port: Int?
)