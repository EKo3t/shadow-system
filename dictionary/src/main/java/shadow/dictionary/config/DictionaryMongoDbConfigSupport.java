package shadow.dictionary.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.MongoConfigurationSupport;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.convert.NoOpDbRefResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class DictionaryMongoDbConfigSupport extends MongoConfigurationSupport {

    private final MongoDbAppProperties properties;

    @Autowired
    public DictionaryMongoDbConfigSupport(MongoDbAppProperties properties) {
        this.properties = properties;
    }

    @Bean
    public MongoClient mongoClient(MongoClientSettings clientSettings) {
        return MongoClients.create(clientSettings);
    }

    @Bean
    public MongoDatabaseFactory reactiveMongoDatabaseFactory(MongoClient mongoClient, MongoDbAppProperties config) {
        return new SimpleMongoClientDatabaseFactory(mongoClient, config.getDbname());
    }

    @Bean
    public MongoClientSettings mongoClientSettings(MongoDbAppProperties config) {
        ConnectionString ConnectionString = createConnectionString(config);
        return MongoClientSettings.builder()
            .applyConnectionString(ConnectionString)
            .build();
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory, MongoConverter converter) {
        return new MongoTemplate(mongoDatabaseFactory, converter);
    }

    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory,
                                                       MongoCustomConversions customConversions, MongoMappingContext mappingContext) {
        MappingMongoConverter converter = new MappingMongoConverter(NoOpDbRefResolver.INSTANCE, mappingContext);
        converter.setCustomConversions(customConversions);
        converter.setCodecRegistryProvider(databaseFactory);
        converter.afterPropertiesSet();

        return converter;
    }

    private ConnectionString createConnectionString(MongoDbAppProperties config) {
        return new ConnectionString(config.getPrefix() + config.getUsername() + ":" + config.getPassword() +
            "@" + config.getDbname() + "." + config.getDomain() + "/?retryWrites=true&w=majority"
        );
    }

    @Override
    protected String getDatabaseName() {
        return properties.getDbname();
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}