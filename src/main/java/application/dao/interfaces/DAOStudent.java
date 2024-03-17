package application.dao.interfaces;

import application.entity.Student;

import java.util.List;

public interface DAOStudent extends DAO<Student> {

    List<Student> getAllStudents();

    List<Student> readByName(String name);

    List<Student> readBySurname(String surname);

    List<Student> readByAddress(String address);

    List<Student> readByAge(int age);

    List<Student> readByMark(int mark);
}
