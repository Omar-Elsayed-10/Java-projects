# Product Management REST API

A Spring Boot-based RESTful API designed to manage a product catalog. This project demonstrates a clean 3-tier architecture (Controller, Service, Repository) using Spring Data JPA and an H2 in-memory database.

## 🚀 Technologies Used
* **Java 17+**
* **Spring Boot 3**
* **Spring Data JPA** (Persistence)
* **H2 Database** (In-memory storage)
* **SpringDoc OpenAPI (Swagger)** (API Documentation)
* **Lombok** (Boilerplate reduction)

## 📂 Project Structure
The project follows a package-by-feature structure:
* `api`: Contains REST Controllers and Request/Response DTOs.
* `service`: Contains business logic.
* `domain`: Contains JPA Entities and Repositories.
* `support`: Contains Mappers and custom Exception handling.

## 🛠️ API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/v1/products` | Retrieve all products |
| **GET** | `/api/v1/products/{id}` | Retrieve a specific product by ID |
| **POST** | `/api/v1/products` | Create a new product |
| **PUT** | `/api/v1/products/{id}` | Update an existing product |
| **DELETE** | `/api/v1/products/{id}` | Remove a product |
| **GET** | `/api/v1/products/search?name=...` | Search products by name (case-insensitive) |

<img width="2048" height="819" alt="image" src="https://github.com/user-attachments/assets/42e8ec9c-120a-419f-bfa3-efea9c34f6b8" />


## 🧪 Testing the API

### 1. Swagger UI
Once the application is running, you can test all endpoints through the interactive Swagger interface:
* **URL:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### 2. H2 Database Console
To inspect the live data stored in your database:
* **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **User:** `sa`
* **Password:** *(leave blank)*
<img width="1749" height="638" alt="image" src="https://github.com/user-attachments/assets/9692fc4c-dd49-42a5-9955-a0f1239e78c2" />



## ⚙️ Configuration
The project is configured via `src/main/resources/application.properties`. It includes settings for:
* Enabling the H2 Console.
* Configuring the In-memory database URL.
* Showing SQL queries in the console for debugging.

## 🏃 How to Run
1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Wait for Maven to load dependencies.
4. Run the `FirstRestApiSpringApplication` class.
5. The application will start on port `8080`.
