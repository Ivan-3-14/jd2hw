package application.services.impl;

import application.dao.imp.DAOImplStudent;
import application.dao.interfaces.DAOStudent;
import application.dto.StudentDTO;
import application.entity.Student;
import application.services.interfaces.StudentServiceInt;
import application.utils.hibernate.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService implements StudentServiceInt {

    private final EntityManager entityManager = HibernateUtil.getEntityManager();
    private static final StudentService INSTANCE = new StudentService();
    private final DAOStudent daoImplStudent = new DAOImplStudent(entityManager);

    @Override
    public List<StudentDTO> getAllStudents() {
        return daoImplStudent.getAllStudents()
                .stream()
                .map(student ->
                        new StudentDTO(
                                student.getId(),
                                student.getName(),
                                student.getSurname(),
                                student.getAddress(),
                                student.getAge(),
                                student.getMark())
                ).collect(Collectors.toList());
    }

    @Override
    public StudentDTO createStudent(StudentDTO student) {
        return null;
    }

    @Override
    public StudentDTO readStudent(int id) {
        Student student = daoImplStudent.read(id);
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getAddress(),
                student.getAge(),
                student.getMark());
    }

    @Override
    public StudentDTO updateStudent(int id, StudentDTO student) {
        return null;
    }

    @Override
    public Integer deleteStudent(int studentId) {
        return null;
    }

    public void closeEntityManager() {
        if (entityManager.isOpen()) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
            }
            entityManager.close();
        }
    }

    private StudentService() {
    }

    public static StudentService getINSTANCE() {
        return INSTANCE;
    }
}
