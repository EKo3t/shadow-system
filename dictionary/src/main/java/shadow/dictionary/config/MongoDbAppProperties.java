package shadow.dictionary.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:mongodb.properties")
@NoArgsConstructor
@Getter
@Setter
public class MongoDbAppProperties {

    @Value("${dictionary.mongodb.prefix}")
    private String prefix;

    @Value("${dictionary.mongodb.domain}")
    private String domain;

    @Value("${dictionary.mongodb.username}")
    private String username;

    @Value("${dictionary.mongodb.password}")
    private String password;

    @Value("${dictionary.mongodb.dbname}")
    private String dbname;
}
