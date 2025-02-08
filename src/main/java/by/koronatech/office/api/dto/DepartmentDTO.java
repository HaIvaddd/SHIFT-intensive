package by.koronatech.office.api.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class DepartmentDTO {
    private int id;
    private String name;
}