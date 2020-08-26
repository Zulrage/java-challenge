package jp.co.axa.apidemo.dto.mappers;

import jp.co.axa.apidemo.dto.CreateOrEditEmployeeRequestDto;
import jp.co.axa.apidemo.entities.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * Mapper for the employee DTO for creation and update.
 *
 * @author bertrand.hieronymus
 */
@ApplicationScope
@Component
public class CreateOrEditEmployeeDtoMapper extends AbstractMapper<Employee, CreateOrEditEmployeeRequestDto> {

    @Override
    public CreateOrEditEmployeeRequestDto mapToDto(Employee entity) {
        if (entity == null) {
            return null;
        }
        CreateOrEditEmployeeRequestDto dto = new CreateOrEditEmployeeRequestDto();
        dto.setDepartment(entity.getDepartment());
        dto.setName(entity.getName());
        dto.setSalary(entity.getSalary());
        return dto;
    }

    @Override
    public Employee mapToEntity(CreateOrEditEmployeeRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Employee entity = new Employee();
        entity.setDepartment(dto.getDepartment());
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());
        return entity;
    }

}
