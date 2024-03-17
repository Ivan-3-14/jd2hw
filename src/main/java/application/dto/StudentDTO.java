package application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentDTO {

    private int id;
    private String name;
    private String surname;
    private String address;
    private int age;
    private int mark;
}
