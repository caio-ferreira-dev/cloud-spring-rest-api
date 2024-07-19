# cloud-spring-rest-api
A project for practicing API development usign java with spring

## Class Diagram
```
classDiagram
    class User {
        -String username
        -String password
    }

    class Note {
        -String name
        -String content
        -boolean favorite
        -String color
    }

    User "1" --> "0..*" Note : has
```