package by.koronatech.office.core.mapper;

import by.koronatech.office.api.dto.DepartmentDTO;
import by.koronatech.office.core.Department;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapper.class)
public interface DepartmentMapper extends BaseMapper<Department, DepartmentDTO> {
}
