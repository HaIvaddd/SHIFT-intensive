package by.koronatech.office.core.mapper;

import by.koronatech.office.api.dto.CreateEmployeeDTO;
import by.koronatech.office.core.Department;
import by.koronatech.office.core.Employee;
import by.koronatech.office.core.repository.DepartmentRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = BaseMapper.class)
public interface CreateEmployeeMapper extends BaseMapper<Employee, CreateEmployeeDTO> {
    @Mapping(source = "department.name", target = "departmentName")
    CreateEmployeeDTO toDTO(Employee employee);

    @Mapping(target = "department", source = "departmentName", qualifiedByName = "mapStringToDepartment")
    Employee toEntity(CreateEmployeeDTO createEmployeeDTO, @Context DepartmentRepository departmentRepository);

    @Named("mapStringToDepartment")
    default Department mapStringToDepartment(String department, @Context DepartmentRepository departmentRep){
        if(department == null) return null;
        return departmentRep.findDepartmentByName(department);
    }
}
