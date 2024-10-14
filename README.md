### Project Description and README for Your Spring Boot Bean Scope Project

You can use the following project description and README template for your GitHub repository. Make sure to adjust the parts that are specific to your project as needed.

---

# Spring Boot Bean Scope Demo

### Project Description

This project demonstrates the various **Spring bean scopes** and their behavior in a real-world Spring Boot application. The project covers the following Spring bean scopes:

- **Singleton Scope**: A single instance per Spring container.
- **Prototype Scope**: A new instance every time the bean is requested.
- **Request Scope**: A new instance per HTTP request (for web applications).
- **Session Scope**: A new instance per HTTP session (for web applications).

The project includes examples and tests showing how Spring manages these different bean scopes and how you can use them to manage bean lifecycles in a Spring Boot web application.

### Technologies Used:
- Java 17
- Spring Boot 2.7.x
- Spring MVC
- JUnit 5
- MockMvc for testing
- Maven

### Features:
- Demonstrates the behavior of different bean scopes in Spring.
- Shows how to use `@Scope("prototype")`, `@RequestScope`, `@SessionScope`, and `@Scope("singleton")`.
- Uses `MockMvc` and multithreading to simulate real-world scenarios for testing scope behavior.
- Provides detailed test cases for each bean scope.

---

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6+
- Spring Boot 2.7.x or later

### Running the Application

To run the application locally, follow these steps:

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/spring-boot-bean-scope-demo.git
    ```

2. Navigate to the project directory:

    ```bash
    cd spring-boot-bean-scope-demo
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

5. The application will start running at `http://localhost:8080`.

### Endpoints

The application exposes several REST endpoints that demonstrate the behavior of different bean scopes.

- **Singleton Scope**: 
  - Endpoint: `/scope/singleton`
  - Description: Returns the unique instance ID of the singleton-scoped bean.

- **Prototype Scope**: 
  - Endpoint: `/scope/prototype`
  - Description: Returns a new instance ID of the prototype-scoped bean for each request.

- **Request Scope**: 
  - Endpoint: `/scope/request`
  - Description: Returns the instance ID of the request-scoped bean, unique for each HTTP request.

- **Session Scope**: 
  - Endpoint: `/scope/session`
  - Description: Returns the instance ID of the session-scoped bean, shared within the same HTTP session.

---

## Running the Tests

The project includes unit and integration tests that demonstrate the behavior of Spring bean scopes, especially under concurrent access.

To run the tests:

1. Run the tests using Maven:

    ```bash
    mvn test
    ```

### Notable Tests:

- **Prototype Scope Test with Threads**: 
  - Tests that multiple threads receive different instances of a prototype-scoped bean.
  - Check out the `PrototypeBeanScopeTest` class in the `test` folder.

- **Request Scope Test**:
  - Simulates different HTTP requests and ensures each request gets a unique request-scoped bean.

- **Session Scope Test**:
  - Simulates different HTTP sessions and tests that the session-scoped bean is shared across requests in the same session but differs across different sessions.

---

## Project Structure

```bash
spring-boot-bean-scope-demo
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com/example/beanscope
│   │   │       ├── ScopeBeanController.java    # REST controller to expose bean scope behavior
│   │   │       ├── SingletonBean.java          # Singleton scoped bean
│   │   │       ├── PrototypeBean.java          # Prototype scoped bean
│   │   │       ├── RequestScopedBean.java      # Request scoped bean
│   │   │       ├── SessionScopedBean.java      # Session scoped bean
│   │   └── resources
│   │       └── application.properties          # Spring Boot configuration
│   ├── test
│   │   └── java
│   │       └── com/example/beanscope
│   │           ├── PrototypeBeanScopeTest.java # Test class for prototype bean scope using threads
│   │           ├── ScopeBeanControllerTest.java# Integration test for various scopes
├── pom.xml                                      # Maven dependencies and build configuration
```

---

## Contributing

If you wish to contribute to this project, feel free to fork the repository and submit a pull request.

### Steps for Contribution:

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a new Pull Request

---

## Contact

If you have any questions or feedback, feel free to contact me at:

- GitHub: [ayoubezzouitine](https://github.com/ayoubezzouitine)
- Email: ezzouitine.ayoub@example.com

---

## Conclusion

This project provides a hands-on demonstration of how Spring Boot handles different bean scopes, including singleton, prototype, request, and session scopes. By running and testing this project, you can deepen your understanding of Spring’s IoC container and how bean lifecycles can be managed to suit different application needs.

---
