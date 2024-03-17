package application.services.interfaces;

import application.dto.StudentDTO;

public interface Service {

    StudentDTO createStudent(StudentDTO student);

    StudentDTO readStudent(int id);

    StudentDTO updateStudent(int id, StudentDTO student);

    Integer deleteStudent(int studentId);
}
