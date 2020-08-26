package jp.co.axa.apidemo.dto.mappers;

import jp.co.axa.apidemo.dto.EmployeeDto;
import jp.co.axa.apidemo.entities.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * Mapper for the employee DTO.
 *
 * @author bertrand.hieronymus
 */
@ApplicationScope
@Component
public class EmployeeDtoMapper extends AbstractMapper<Employee, EmployeeDto> {

    @Override
    public EmployeeDto mapToDto(Employee entity) {
        if (entity == null) {
            return null;
        }
        EmployeeDto dto = new EmployeeDto();
        dto.setId(entity.getId());
        dto.setDepartment(entity.getDepartment());
        dto.setName(entity.getName());
        dto.setSalary(entity.getSalary());
        return dto;
    }

    @Override
    public Employee mapToEntity(EmployeeDto dto) {
        if (dto == null) {
            return null;
        }
        Employee entity = new Employee();
        entity.setId(dto.getId());
        entity.setDepartment(dto.getDepartment());
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());
        return entity;
    }

}
