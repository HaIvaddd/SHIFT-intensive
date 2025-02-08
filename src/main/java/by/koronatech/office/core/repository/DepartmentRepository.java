package by.koronatech.office.core.repository;

import by.koronatech.office.core.Department;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
@Getter
public class DepartmentRepository {

    private final Map<Integer, Department> departments = new HashMap<>();

    public void addDepartment(Department department) {
        departments.put(department.getId(), department);
    }

    public Department findDepartmentByName(String name) {
        return departments.values().stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }
}
