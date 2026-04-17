# First Spring Boot Project - Vistula University

This is my first web application built using the **Spring Boot** framework and **Thymeleaf** template engine.

## Use Case Examples

### 1. Home Page (Plain Text Response)
The application handles a basic request at the root URL. This demonstrates the use of `@GetMapping` and `@ResponseBody`.
* **URL:** `http://localhost:8080/`
* **Description:** Returns a simple string message directly to the browser.

> **[INSERT SCREENSHOT OF YOUR BROWSER SHOWING "Hello Vistula..."]**

---

### 2. Greeting Page (MVC Pattern)
This demonstrates the **Model-View-Controller** design pattern. It takes a parameter from the URL and displays it on a stylized HTML page.
* **URL:** `http://localhost:8080/greeting?name=Omar`
* **Description:** Uses a Thymeleaf template to display a personalized greeting and the university logo.

> ****

---

# How to Run
1. Clone the repository.
2. Ensure you have **JDK 17 or higher** installed (Project uses JDK 25).
3. Run the application via `FirstProjectJavaSpringApplication.java`.
4. Access the endpoints via `localhost:8080`.