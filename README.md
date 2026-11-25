# Job Application Tracker

I made this project to keep job applications in one place instead of maintaining a separate list. It is a small CRUD application: I can add an application, view the saved entries, edit details and remove an entry when I no longer need it.

## What it can do

- Save the company, role, application date and current status.
- View the applications already saved in the database.
- Update an application's details or delete it.
- Filter the list by status using the frontend controls.
- Send requests to the Spring Boot REST API from a simple browser interface.

## Built with

Java 17, Spring Boot, Spring Data JPA, MySQL, HTML, CSS and JavaScript. I used Postman while checking the API endpoints.

## Run it locally

1. Install JDK 17+, Maven and MySQL.
2. Create a MySQL database, or use the database name configured in `application.properties`.
3. Set your database username and password as environment variables (`DB_USERNAME` and `DB_PASSWORD`). Do not commit real credentials.
4. Check the database URL in `src/main/resources/application.properties` and change it if your local MySQL setup is different.
5. From this folder, run `mvn spring-boot:run`.
6. Open `http://localhost:8080` in your browser.

## API routes

| Method | Route | Purpose |
|---|---|---|
| GET | `/api/applications` | Get all applications |
| POST | `/api/applications` | Add an application |
| PUT | `/api/applications/{id}` | Update an application |
| DELETE | `/api/applications/{id}` | Delete an application |

## Things I would improve next

- Add search by company and role.
- Add proper form validation messages in the browser.
- Add tests for the service and controller layers.
- Add user accounts if I decide to support more than one person.

## Current limitations

This is a local learning project. It does not include user authentication, deployment or automated tests. The application date and status fields are intentionally kept simple. Run it and verify the database connection before relying on it.
