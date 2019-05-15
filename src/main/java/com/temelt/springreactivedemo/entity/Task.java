package com.temelt.springreactivedemo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Project spring-reactive-demo
 * Created by taner on 15.05.2019
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Task {
    @Id
    private String id;
    private String description;
    private String content;
    private Boolean status;
}
