### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.




#### Changelog
 - Formatting, override and add javadoc (did not add javadoc for the service implementation for maintenability (reuse override javadoc))
 - Change name for employee service and implementation to IEmployeeService for interface and EmployeeService for impl (matter of preference, but Interface starting with I are easilly seen and understood)
 - Add some test
 - Add error handling for the application
 -- This could be overengineering the current application, but pertinent error are valuable for maintenability
 - Add DTO and mapping to not use directly the DB entities
 -- Returning DB entities as is could lead to numerous security issues in the future.
 - Remove the get() for optional to a orElseThrow with a custom exception

#### What could have been done
- More unttesting (especially on the controller)
- Split in different project (lib and common lib project)


#### What we will look for
- Readability of your code
- Documentation
- Comments in your code 
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues

