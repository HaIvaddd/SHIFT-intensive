package by.koronatech.office.core.mapper;

import by.koronatech.office.api.dto.EmployeeDTO;
import by.koronatech.office.core.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapper.class)
public interface EmployeeMapper extends BaseMapper<Employee, EmployeeDTO> {
    @Mapping(source = "department.name", target = "departmentName")
    EmployeeDTO toDTO(Employee employee);
}
