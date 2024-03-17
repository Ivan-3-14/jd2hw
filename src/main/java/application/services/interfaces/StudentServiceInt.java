package application.services.interfaces;

import application.dto.StudentDTO;

import java.util.List;

public interface StudentServiceInt extends Service {

    List<StudentDTO> getAllStudents();
}
