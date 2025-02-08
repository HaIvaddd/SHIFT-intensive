package by.koronatech.office.core;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
public class Employee {
    private int id;
    private String name;
    private BigDecimal salary;
    private Department department;
    private boolean manager;

    public boolean getManager() {
        return manager;
    }
}
