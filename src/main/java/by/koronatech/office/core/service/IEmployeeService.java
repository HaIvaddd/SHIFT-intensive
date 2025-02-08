package by.koronatech.office.core.service;

import by.koronatech.office.api.dto.CreateEmployeeDTO;
import by.koronatech.office.api.dto.EmployeeDTO;
import java.util.List;

public interface IEmployeeService {
    //2. Добавление сотрудника в отдел
    //3. Получение всех сотрудников отдела
    //4. Сделать сотрудника менеджером отдела
    //5. Изменение существующей информации о сотруднике
    //6. Удаление сотрудника из отдела
    EmployeeDTO createEmployee(CreateEmployeeDTO employeeDTO);
    List<EmployeeDTO> findAllEmployeesByDepartment(String department);
    EmployeeDTO setManagerEmployee(int employeeId);
    EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO);
    void deleteEmployee(int employeeId);
}
