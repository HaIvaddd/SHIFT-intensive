package by.koronatech.office.core.repository;

import by.koronatech.office.core.Employee;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Getter
public class EmployeeRepository {
    private final Map<Integer , Employee> employees = new HashMap<>();

    public Employee findEmployeeById(int id) {
        return employees.get(id);
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public void deleteEmployee(int id) {
        employees.remove(id);
    }
}
