# 💸 Expense Tracker API

A RESTful API for managing expenses, built with **Spring Boot** and **MySQL**. It allows users to add, view, filter, and get summary of their expenses.

## 🚀 Features

- Add new expenses
- Get all expenses
- Filter expenses by category
- View individual expense by ID
- Get a summary of total expenses by category
- Exception handling with custom error messages

---

## 🔧 Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **MySQL 8**
- **JPA/Hibernate**
- **Maven**
- **Postman** for testing APIs
- **VS Code** (recommended)

---

## ⚙️ Setup Instructions

### ✅ Prerequisites

- Java 17+
- Maven
- MySQL
- Git

### 🧑‍💻 Steps to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/imDharmanderyadav/expense-tracker-api.git
   cd expense-tracker-api

2. **Configure application.properties**
   spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password

3. **Create the Database**
    CREATE DATABASE expense_tracker;

4. **Build and run the project**
    mvn spring-boot:run

## 📡 API Endpoints

# 🔹 Base URL
http://localhost:8080/api/expenses

# 📥 Create a new expense
POST /api/expenses
Content-Type: application/json
Body:
{
  "title": "Grocery Shopping",
  "amount": 120.50,
  "date": "2025-04-01",
  "category": "FOOD"
}

# 📃 Get all expenses
GET /api/expenses

# 🔍 Get expense by ID
GET /api/expenses/{id}

# ✏️ Update an expense
PUT /api/expenses/{id}
Content-Type: application/json
Body:
{
  "title": "Updated Title",
  "amount": 180.00,
  "date": "2025-04-02",
  "category": "TRANSPORT"
}

# ❌ Delete an expense
DELETE /api/expenses/{id}

# 📂 Filter by category
GET /api/expenses/category/{category}
# Example:
GET /api/expenses/category/FOOD

# 📊 Expense summary by category
GET /api/expenses/summary

---

## 👤 Author

**Dharmander Yadav**

- GitHub: [@imDharmanderyadav](https://github.com/imDharmanderyadav)
- LinkedIn: [Dharmander Yadav](https://www.linkedin.com/in/dharmander-yadav)


---



> Thank you for checking out this project! ⭐ it if you found it helpful or learned something new.
