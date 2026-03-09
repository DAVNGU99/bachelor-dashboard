# Bachelor Dashboard

A Scrumban-based project management application built as a bachelor project. Combines Scrum's structure with Kanban's flexibility to help teams manage tasks, sprints, and workflows.

## Tech Stack

**Backend**
- Java 21 + Spring Boot
- Spring Security with JWT Bearer Token authentication
- PostgreSQL (hosted on Supabase)
- Flyway for database migrations
- Swagger / OpenAPI for API documentation
- Docker for containerization

**Infrastructure**
- Backend deployed on [Render](https://render.com)
- Frontend deployed on [Vercel](https://vercel.com)

## Features

- JWT-based authentication and authorization
- Scrumban board for task and sprint management
- RESTful API documented with Swagger UI
- Schema-managed database via Flyway migrations

## Getting Started

### Prerequisites

- Java 21+
- Maven
- PostgreSQL (or a Supabase project)

### Clone and run locally

```bash
git clone https://github.com/DAVNGU99/bachelor-dashboard.git
cd bachelor-dashboard
```

Set up your environment variables (see `.env.example`):

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5433/dashboard
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
JWT_SECRET=your-secret-here
PORT=8080
```

Run the application:

```bash
./mvnw spring-boot:run
```

### Docker

```bash
docker build -t bachelor-dashboard .
docker run -p 8080:8080 --env-file .env bachelor-dashboard
```

## API Documentation

Once running, Swagger UI is available at:

```
[http://localhost:8080/swagger-ui.html]
```

![Swagger UI schema](https://cdn.discordapp.com/attachments/657297914879672330/1480309502044537003/image.png?ex=69af3528&is=69ade3a8&hm=ab714bbb358a3bb8ffe64d0a3534293c8780c4755c48d9f508d4449812dc4df4)



## Project Structure

```
src/
├── main/
│   ├── java/         # Application source code
│   └── resources/
│       ├── application.properties
│       └── db/migration/   # Flyway migrations
```

## Relational Database Schema
![Datbase schema](https://cdn.discordapp.com/attachments/657297914879672330/1480642433774522511/image.png?ex=69b06b39&is=69af19b9&hm=e311252c1dc802006e4ad6c83b1f9747edc193f0f5dfabb4e387c1ab32a3dcdb&)

## Environment Variables

| Variable | Description |
|---|---|
| `SPRING_DATASOURCE_URL` | PostgreSQL connection URL |
| `SPRING_DATASOURCE_USERNAME` | Database username |
| `SPRING_DATASOURCE_PASSWORD` | Database password |
| `JWT_SECRET` | Secret key for signing JWT tokens |
| `PORT` | Server port (default: 8080) |
