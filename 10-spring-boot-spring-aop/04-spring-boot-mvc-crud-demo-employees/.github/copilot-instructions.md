# Copilot Instructions for AI Agents

## Project Overview
- This is a Spring Boot MVC CRUD application for managing employees, using Thymeleaf for templating and MySQL for persistence.
- Main package: `com.luv2code.springboot.thymeleafdemo`.
- Key layers: Controller (`controller/`), Service (`service/`), DAO/Repository (`dao/`), Entity (`entity/`).
- Data flow: Controller → Service → Repository (DAO) → MySQL DB.
- Thymeleaf templates are in `src/main/resources/templates/`.

## Build & Run
- Use Maven for all build and dependency management: `./mvnw clean package` (or `mvnw.cmd` on Windows).
- Run the app: `./mvnw spring-boot:run` or run the generated jar in `target/`.
- MySQL must be running and accessible as configured in `application.properties`.
- DB schema is in `sql-scripts/employee-directory.sql`.

## Testing
- Tests are in `src/test/java/com/luv2code/springboot/thymeleafdemo/`.
- Run tests with `./mvnw test`.

## Patterns & Conventions
- Use constructor injection for services and repositories.
- Repository interfaces extend `JpaRepository` and may define custom query methods (see `EmployeeRepository`).
- Service interfaces are implemented by `*ServiceImpl` classes.
- Thymeleaf templates use Bootstrap for styling and are organized by feature (e.g., `employees/`).
- All employee CRUD operations are routed under `/employees`.
- Use `findAllByOrderByLastNameAsc()` for sorted employee lists.

## Integration Points
- MySQL connection details are in `application.properties`.
- No external APIs are called; all data is local DB.

## Examples
- To add a new employee, POST to `/employees/save` with form data matching the `Employee` entity fields.
- To update, use `/employees/showFormForUpdate?employeeId={id}`.
- To delete, use `/employees/delete?employeeId={id}`.

## Key Files
- `EmployeeController.java`: Main web controller for employee CRUD.
- `EmployeeService.java`/`EmployeeServiceImpl.java`: Business logic.
- `EmployeeRepository.java`: Data access.
- `Employee.java`: Entity definition.
- `list-employees.html`, `employee-form.html`: Main UI templates.

---

For new features, follow the existing layering and naming conventions. For DB changes, update both the entity and the SQL script. For UI, use Thymeleaf and Bootstrap as in current templates.
