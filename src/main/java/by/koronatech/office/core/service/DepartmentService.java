package by.koronatech.office.core.service;

import by.koronatech.office.api.dto.DepartmentDTO;
import by.koronatech.office.core.mapper.DepartmentMapper;
import by.koronatech.office.core.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentMapper.toDTOs(departmentRepository.getDepartments().values().stream().toList());
    }
}
