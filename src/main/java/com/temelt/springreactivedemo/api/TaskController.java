package com.temelt.springreactivedemo.api;

import com.temelt.springreactivedemo.entity.Task;
import com.temelt.springreactivedemo.repo.TaskRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Project spring-reactive-demo
 * Created by taner on 15.05.2019
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public Flux<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @PostMapping
    public Mono<Task> create(@RequestBody Task task) {
        return this.taskRepository.save(task);
    }

    @GetMapping("/{id}")
    public Mono<Task> get(@PathVariable("id") String id) {
        return this.taskRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Task> update(@PathVariable("id") String id, @RequestBody Task task) {
        return this.taskRepository.findById(id)
                .map(p -> {
                    p.setDescription(task.getDescription());
                    p.setContent(task.getContent());
                    p.setStatus(Boolean.TRUE);
                    return p;
                })
                .flatMap(p -> this.taskRepository.save(p));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return this.taskRepository.deleteById(id);
    }
}
