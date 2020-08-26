package jp.co.axa.apidemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jp.co.axa.apidemo.dto.CreateOrEditEmployeeRequestDto;
import jp.co.axa.apidemo.dto.EmployeeDto;
import jp.co.axa.apidemo.exception.ApiDemoBusinessException;
import jp.co.axa.apidemo.services.IEmployeeService;

/**
 * Controller for the employee rest resources.
 *
 * @author bertrand.hieronymus
 */
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    public void setEmployeeService(IEmployeeService employeeService) throws ApiDemoBusinessException {
        this.employeeService = employeeService;
    }

    /**
     * Return the complete list of employees.
     *
     * @return
     */
    @GetMapping
    public @ResponseBody
    List<EmployeeDto> getEmployees() {
        return employeeService.retrieveEmployees();
    }

    /**
     * Get an employee via its id.
     *
     * @param employeeId
     * @return
     * @throws ApiDemoBusinessException in case of unknow user
     */
    @GetMapping("/{employeeId}")
    public @ResponseBody
    EmployeeDto getEmployee(@PathVariable(name = "employeeId") Long employeeId) throws ApiDemoBusinessException {
        return employeeService.getEmployee(employeeId);
    }

    /**
     * Add a new employee to the database with a new generated id.
     *
     * @param employee
     */
    @PostMapping
    public void saveEmployee(CreateOrEditEmployeeRequestDto employee) {
        employeeService.saveEmployee(employee);
        System.out.println("Employee Saved Successfully");
    }

    /**
     * Delete an employee via its id.
     *
     * @param employeeId target employee
     * @throws ApiDemoBusinessException in case of unknow user
     */
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) throws ApiDemoBusinessException {
        employeeService.deleteEmployee(employeeId);
        System.out.println("Employee Deleted Successfully");
    }

    /**
     * Update an employee to a new value.
     *
     * @param employeeId targeted employee id
     * @param employee new value
     * @throws ApiDemoBusinessException mismatched ids or unknow user
     */
    @PutMapping("/{employeeId}")
    public void updateEmployee(@RequestBody CreateOrEditEmployeeRequestDto employee,
            @PathVariable(name = "employeeId") Long employeeId) throws ApiDemoBusinessException {
        employeeService.updateEmployee(employeeId, employee);
        System.out.println("Employee Updated Successfully");
    }
}
