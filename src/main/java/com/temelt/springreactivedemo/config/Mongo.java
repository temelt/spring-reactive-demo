package com.temelt.springreactivedemo.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Project spring-reactive-demo
 * Created by taner on 15.05.2019
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.temelt")
public class Mongo extends AbstractReactiveMongoConfiguration {

    @Value("${mongo.uri}")
    String mongoUri;
    @Value("${mongo.database}")
    String database;

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Override
    protected String getDatabaseName() {
        return this.database;
    }

}
