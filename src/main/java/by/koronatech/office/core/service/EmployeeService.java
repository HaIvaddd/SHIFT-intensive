package by.koronatech.office.core.service;

import by.koronatech.office.api.dto.CreateEmployeeDTO;
import by.koronatech.office.api.dto.EmployeeDTO;
import by.koronatech.office.core.mapper.CreateEmployeeMapper;
import by.koronatech.office.core.mapper.EmployeeMapper;
import by.koronatech.office.core.repository.DepartmentRepository;
import by.koronatech.office.core.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    private final EmployeeMapper employeeMapper;
    private final CreateEmployeeMapper createEmployeeMapper;

    @Override
    public EmployeeDTO createEmployee(CreateEmployeeDTO createEmployeeDTO) {
        employeeRepository.addEmployee(createEmployeeMapper.toEntity(createEmployeeDTO, departmentRepository));
        return employeeMapper.toDTO(createEmployeeMapper.toEntity(createEmployeeDTO, departmentRepository));
    }

    @Override
    public List<EmployeeDTO> findAllEmployeesByDepartment(String department) {
        return employeeMapper
                .toDTOs(employeeRepository.getEmployees().values().stream().toList())
                .stream()
                .filter(employee -> employee.getDepartmentName().equals(department))
                .toList();
    }

    @Override
    public EmployeeDTO setManagerEmployee(int employeeId) {
        employeeRepository.findEmployeeById(employeeId).setManager(true);//Можно добавить обработку, что сотрудник уже менеджер
        return employeeMapper.toDTO(employeeRepository.findEmployeeById(employeeId));
    }

    @Override
    public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) {
        return employeeMapper.toDTO(employeeMapper.merge(employeeRepository.findEmployeeById(id), employeeDTO));
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteEmployee(employeeId);
    }
}
