# First Spring Boot Project - Vistula University

This is my first web application built using the **Spring Boot** framework and **Thymeleaf** template engine.


### 1. Home Page 
The application handles a basic request at the root URL. This demonstrates the use of `@GetMapping` and `@ResponseBody`.
 **URL:** `http://localhost:8080/`
 **Description:** Returns a simple string message directly to the browser.

<img width="2528" height="1338" alt="Screenshot 2026-04-18 012949" src="https://github.com/user-attachments/assets/e9dc1d61-2397-4c80-9052-3f7da953a1e0" />

---

### 2. Greeting Page 
This demonstrates the **Model-View-Controller** design pattern. It takes a parameter from the URL and displays it on a stylized HTML page.
* **URL:** `http://localhost:8080/greeting?name=Omar`
* **Description:** Uses a Thymeleaf template to display a personalized greeting and the university logo.

<img width="1096" height="1098" alt="Screenshot 2026-04-18 012520" src="https://github.com/user-attachments/assets/acaf0c9b-39ef-41ad-886a-45ea8f4ea1a4" />


---

# How to Run
1. Clone the repository.
2. Ensure you have **JDK 17 or higher** installed (Project uses JDK 25).
3. Run the application via `FirstProjectJavaSpringApplication.java`.
4. Access the endpoints via `localhost:8080`.
