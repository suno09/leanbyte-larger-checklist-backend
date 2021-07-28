package de.leanbyte.checklisttask.config;

import com.arangodb.ArangoDB;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

/**
 * ArangoDB configuration class
 */
@Configuration
@EnableArangoRepositories(basePackages = {"de.leanbyte.checklisttask"})
class ArangoDBConfiguration implements ArangoConfiguration {

    /**
     * Build arangodb from arangodb.properties
     *
     * @return ArangoDB Builder
     */
    @Override
    public ArangoDB.Builder arango() {
        InputStream in = ArangoDBConfiguration.class.getResourceAsStream("arangodb.properties");
        ArangoDB.Builder arango = new ArangoDB
                .Builder()
                .loadProperties(in);
        return arango;
    }

    /**
     * Database name
     *
     * @return String
     */
    @Override
    public String database() {
        return "leanbyte_checklist";
    }
}
