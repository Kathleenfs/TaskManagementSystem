# TaskManagementSystem  

A simple CRUD-based Task Management System designed to manage tasks with categories, deadlines, and statuses. The project aims to provide a user-friendly way to organize tasks efficiently, using modern technologies for both backend and frontend development.  

## Development Process 🛠  

This project was planned and developed following Agile principles using the Scrum framework. The planning and task management were organized using *Trello*, with tasks categorized into:  
- *Backlog*: Features and ideas to be implemented.  
- *In Progress*: Tasks currently under development.  
- *Done*: Completed tasks.  

### Why Trello?  
Using Trello helped in:  
1. *Visualizing progress*: A clear Kanban board provided real-time updates on the status of each task.  
2. *Prioritization*: Ensured that high-value features were implemented first.  
3. *Collaboration*: Facilitated teamwork and task delegation (if working with a team).  

To demonstrate, here's a snapshot of the Trello board used for this project:  
[Link To Trello Board ](https://trello.com/invite/b/66a6827d42d76b9dc346601c/ATTI451ba54928fd9d1abff75a5cbed085a944CBBEC1/gestao-de-projetos)
![image](https://github.com/user-attachments/assets/10b036c1-75e3-4369-8131-112f76202acd)

## Features  
- Create, read, update, and delete tasks.  
- Categorize tasks for better organization.  
- Track task deadlines and statuses (e.g., Pending, In Progress, Completed).  
- REST API backend for seamless data interaction.  
- Responsive and interactive frontend for an enhanced user experience.  

## Tech Stack  
### Backend  
- *Spring Boot*: Provides the REST API.  
- *JPA/Hibernate*: For Object Relational Mapping (ORM).  
- *Swagger*: For API documentation.  

### Frontend  
- *React*: A modern JavaScript library for building user interfaces.  

### Database  
- *PostgreSQL*: A powerful, open-source relational database system.  

## Installation  
### Prerequisites  
- *Java 17 or higher*  
- *Node.js & npm*  
- *PostgreSQL*  
- *Maven*

### Backend Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/Kathleenfs/TaskManagementSystem.git
    cd TaskManagementSystem/backend
    ```

2. **Configure the database in `application.properties`:**

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanagement
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

3. **Build and run the backend:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### Frontend Setup

1. **Navigate to the frontend folder:**

    ```bash
    cd ../frontend
    ```

2. **Install dependencies:**

    ```bash
    npm install
    ```

3. **Start the development server:**

    ```bash
    npm start
    ```

## Access the Application

- **Frontend**: [http://localhost:3000](http://localhost:3000)
- **API Documentation (Swagger)**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Project Structure :card_index_dividers:
```P
TaskManagementSystem/
├── backend/       # Spring Boot backend
├── frontend/      # React frontend 
├── database/      # Database scripts and configurations
└── README.md      # Project documentation
   ```

## Future Enhancements

- **Add user authentication and authorization.**
- **Implement task prioritization.**
- **Integrate notifications for deadlines.**

## License :lock:

This project is licensed under the **MIT License**.

## Contributing :handshake:

Contributions are welcome! Please fork the repository and submit a pull request with your proposed changes.

## Contact :mailbox_with_mail:

For questions or support, feel free to contact [Kathleen Ferreira](mailto:kathleenfss4@gmail.com).
