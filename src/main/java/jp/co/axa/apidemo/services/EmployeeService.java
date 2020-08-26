package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jp.co.axa.apidemo.dto.CreateOrEditEmployeeRequestDto;
import jp.co.axa.apidemo.dto.EmployeeDto;
import jp.co.axa.apidemo.dto.mappers.CreateOrEditEmployeeDtoMapper;
import jp.co.axa.apidemo.dto.mappers.EmployeeDtoMapper;
import jp.co.axa.apidemo.exception.ApiDemoBusinessException;
import jp.co.axa.apidemo.exception.ErrorCode;

/**
 * Service implementation sfor the employee logic.
 *
 * @author berrand.hieronymus
 */
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDtoMapper employeeDtoMapper;

    @Autowired
    private CreateOrEditEmployeeDtoMapper createOrEditEmployeeDtoMapper;

    @Override
    public List<EmployeeDto> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeDtoMapper.mapToDtoList(employees);
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) throws ApiDemoBusinessException {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return employeeDtoMapper.mapToDto(
                optEmp.orElseThrow(() -> new ApiDemoBusinessException(ErrorCode.NO_DATA, "Unknown employee.")));
    }

    @Override
    public void saveEmployee(CreateOrEditEmployeeRequestDto employee) {
        Employee newEntity = createOrEditEmployeeDtoMapper.mapToEntity(employee);
        employeeRepository.save(newEntity);
    }

    @Override
    public void deleteEmployee(Long employeeId) throws ApiDemoBusinessException {
        EmployeeDto emp = getEmployee(employeeId);
        if (emp == null) {
            throw new ApiDemoBusinessException(ErrorCode.NO_DATA, "Unknown employee.");
        }

        employeeRepository.deleteById(employeeId);
    }

    @Override
    public void updateEmployee(Long employeeId, CreateOrEditEmployeeRequestDto employee) throws ApiDemoBusinessException {
        EmployeeDto emp = getEmployee(employeeId);
        if (emp == null) {
            throw new ApiDemoBusinessException(ErrorCode.NO_DATA, "Unknown employee.");
        }

        Employee newEntity = createOrEditEmployeeDtoMapper.mapToEntity(employee);
        newEntity.setId(employeeId);
        employeeRepository.saveAndFlush(newEntity);
    }
}
