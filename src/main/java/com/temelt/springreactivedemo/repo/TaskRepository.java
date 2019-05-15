package com.temelt.springreactivedemo.repo;

import com.temelt.springreactivedemo.entity.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Project spring-reactive-demo
 * Created by taner on 15.05.2019
 */
public interface TaskRepository extends ReactiveMongoRepository<Task, String> {
}
