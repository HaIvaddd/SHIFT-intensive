package by.koronatech.office.api.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@EqualsAndHashCode
@Builder
public class EmployeeDTO {
    private int id;
    private String name;
    private BigDecimal salary;
    private String departmentName;
    private boolean manager;

    public boolean getManager() {
        return manager;
    }
}
