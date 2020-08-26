package jp.co.axa.apidemo.services;

import java.util.List;
import jp.co.axa.apidemo.dto.CreateOrEditEmployeeRequestDto;
import jp.co.axa.apidemo.dto.EmployeeDto;
import jp.co.axa.apidemo.exception.ApiDemoBusinessException;

/**
 * Service interface for the employee logic.
 *
 * @author berrand.hieronymus
 */
public interface IEmployeeService {

    /**
     * Return the complete list of employees.
     *
     * @return
     */
    public List<EmployeeDto> retrieveEmployees();

    /**
     * Get an employee via its id.
     *
     * @param employeeId
     * @return
     * @throws ApiDemoBusinessException in case of unknow user
     */
    public EmployeeDto getEmployee(Long employeeId) throws ApiDemoBusinessException;

    /**
     * Add a new employee to the database with a new generated id.
     *
     * @param employee
     */
    public void saveEmployee(CreateOrEditEmployeeRequestDto employee);

    /**
     * Delete an employee via its id.
     *
     * @param employeeId target employee
     * @throws ApiDemoBusinessException in case of unknow user
     */
    public void deleteEmployee(Long employeeId) throws ApiDemoBusinessException;

    /**
     * Update an employee to a new value.
     *
     * @param employeeId targeted employee id
     * @param employee new value
     * @throws ApiDemoBusinessException mismatched ids or unknow user
     */
    public void updateEmployee(Long employeeId, CreateOrEditEmployeeRequestDto employee) throws ApiDemoBusinessException;
}
