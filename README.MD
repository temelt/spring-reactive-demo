## spring-reactive-demo
This Project is example of WebFlux, SpringBoot, Reactive, MongoDB.
Project is contains a simple Task REST APIs (CRUD)

```java
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Post {
    @Id
    private String id;
    private String description;
    private String content;
    private Boolean status;
    
}
```


## Prerequisites

* Java 8, https://java.oracle.com
* Apache Maven, https://maven.apache.org
* Your favorite IDE
