# Employee Management System

A full-stack web application for managing employee records with a Spring Boot backend and React frontend. This application allows users to create, view, update, and delete employee information efficiently.

## 🌟 Features

- **View Employees**: Display all employees in a responsive table with sorting and filtering capabilities
- **Add Employee**: Create new employee records with validation
- **Edit Employee**: Update existing employee information
- **Delete Employee**: Remove employee records from the system
- **Email Validation**: Ensures unique and valid email addresses
- **Input Validation**: Client-side and server-side validation for data integrity
- **Responsive UI**: Bootstrap-based responsive design that works on all devices

## 🛠️ Tech Stack

### Backend

- **Framework**: Spring Boot 3.3.1
- **Language**: Java 21
- **Database**: MySQL
- **Build Tool**: Maven
- **Key Dependencies**:
  - Spring Data JPA (ORM)
  - Spring Web (REST API)
  - Lombok (Code generation)
  - Jakarta Validation (Input validation)
  - MySQL Connector J

### Frontend

- **Framework**: React 18.2.0
- **Routing**: React Router DOM 6.24.1
- **HTTP Client**: Axios 1.7.2
- **UI Framework**: React Bootstrap 2.10.4 & Bootstrap 5.3.3
- **Icons**: React Icons 5.2.1
- **Build Tool**: Create React App

## 📁 Project Structure

```
employee-management-system/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/work/sbemployees/
│   │   │   │   ├── controller/       # REST API endpoints
│   │   │   │   ├── model/            # Employee entity
│   │   │   │   ├── service/          # Business logic
│   │   │   │   ├── repository/       # Data access layer
│   │   │   │   └── exception/        # Custom exceptions
│   │   │   └── resources/
│   │   │       └── application.properties  # Configuration
│   │   └── test/
│   ├── pom.xml                       # Maven dependencies
│   └── mvnw                          # Maven wrapper
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── Home.js               # Home page
│   │   │   ├── Navigator.js          # Navigation bar
│   │   │   └── Employee/
│   │   │       ├── EmployeesTable.js # View employees
│   │   │       ├── EmployeeAdder.js  # Add employee form
│   │   │       └── EmployeeEditor.js # Edit employee form
│   │   ├── App.js                    # Main application component
│   │   └── index.js                  # Entry point
│   ├── package.json                  # npm dependencies
│   └── public/
│       └── index.html                # HTML template
├── employeedb_employees.sql          # Database schema
└── README.md
```

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher
- Node.js 14 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher

### Backend Setup

1. **Install MySQL Database**:

   ```bash
   # Create the database and import the schema
   mysql -u root -p < employeedb_employees.sql
   ```

2. **Configure Database Connection**:
   Edit `backend/src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/employeedb
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

3. **Build and Run Backend**:
   ```bash
   cd backend
   mvn clean install
   mvn spring-boot:run
   ```
   The backend will start on `http://localhost:8080`

### Frontend Setup

1. **Install Dependencies**:

   ```bash
   cd frontend
   npm install
   ```

2. **Start Development Server**:
   ```bash
   npm start
   ```
   The frontend will start on `http://localhost:3000`

## 📋 API Endpoints

| Method | Endpoint                 | Description         |
| ------ | ------------------------ | ------------------- |
| GET    | `/employees`             | Get all employees   |
| GET    | `/employees/get/{id}`    | Get employee by ID  |
| POST   | `/employees`             | Create new employee |
| PUT    | `/employees/update/{id}` | Update employee     |
| DELETE | `/employees/delete/{id}` | Delete employee     |

### Example Request

**Create Employee (POST)**:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}
```

## 🗄️ Database Schema

The application uses a MySQL database with a single `employees` table:

```sql
CREATE TABLE employees (
  employee_id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  PRIMARY KEY (employee_id)
);
```

## 🎯 Key Classes

### Backend

- **Employee**: JPA entity representing an employee
- **EmployeeController**: REST controller handling HTTP requests
- **EmployeeService**: Interface defining business logic
- **EmployeeServiceImpl**: Service implementation
- **EmployeeRepository**: JPA repository for database operations

### Frontend

- **App.js**: Main application component with routing
- **EmployeesTable**: Component for displaying all employees
- **EmployeeAdder**: Component for adding new employees
- **EmployeeEditor**: Component for editing existing employees
- **Navigator**: Navigation bar component

## ✅ Validation Rules

### Employee Model

- **First Name**: Required, cannot be empty
- **Last Name**: Required, cannot be empty
- **Email**: Required, must be valid email format, must be unique

## 🌐 CORS Configuration

The backend is configured to accept requests from `http://localhost:3000` (React development server).

## 📝 Development Notes

- The application uses Lombok to reduce boilerplate code
- Spring Data JPA handles all database operations
- React Router handles client-side routing
- Axios is used for HTTP communication between frontend and backend
- Bootstrap provides responsive UI components

## 🤝 Contributing

Contributions are welcome! Feel free to fork this repository and submit pull requests.

## 📄 License

This project is open source and available under the MIT License.

## 👨‍💻 Author

Created as a full-stack application demonstration using Spring Boot and React.

---

**Note**: Update the database credentials in `application.properties` before running the backend.
