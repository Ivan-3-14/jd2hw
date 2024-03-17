package application.dao.imp;

import application.dao.interfaces.DAOStudent;
import application.entity.Student;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static application.utils.constant.ConstantContainer.*;

public class DAOImplStudent extends DAOImpl<Student> implements DAOStudent {

    private static final Logger LOGGER = Logger.getLogger(DAOImplStudent.class.getName());

    public DAOImplStudent(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public Student create(Student student) {
        LOGGER.log(Level.INFO, START_CREATE);
        return super.create(student);
    }

    @Override
    public Student read(int id) {
        LOGGER.log(Level.INFO, START_READ);
        return super.read(id);
    }

    @Override
    public Student update(int id, Student student) {
        LOGGER.log(Level.INFO, START_UPDATE);
        return super.update(id, student);
    }

    @Override
    public Integer delete(int id) {
        LOGGER.log(Level.INFO, START_DELETE);
        return super.delete(id);
    }

    @Override
    public List<Student> getAllStudents() {
        LOGGER.log(Level.INFO, START_GET_ALL_STUDENT);
        List<Student> list = new ArrayList<>();
        try {
            list = getEntityManager()
                    .createQuery(GET_ALL_STUDENT_QUERY, getEntityClass())
                    .getResultList();
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, LIST_OF_STUDENTS_EMPTY);
        }
        LOGGER.log(Level.INFO, GET_ALL_STUDENT_SUCCESSFUL);

        return list;
    }

    @Override
    public List<Student> readByName(String name) {
        LOGGER.log(Level.INFO, START_GET_STUDENT_BY_NAME);
        List<Student> list = new ArrayList<>();
        try {
            list = getEntityManager()
                    .createQuery(GET_STUDENT_BY_NAME, getEntityClass())
                    .setParameter(VALUE, name)
                    .getResultList();
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, LIST_OF_STUDENTS_EMPTY);
        }
        LOGGER.log(Level.INFO, GET_STUDENT_BY_NAME_SUCCESSFUL);
        return list;
    }

    @Override
    public List<Student> readBySurname(String surname) {
        LOGGER.log(Level.INFO, START_GET_STUDENT_BY_SURNAME);
        List<Student> list = new ArrayList<>();
        try {
            list = getEntityManager()
                    .createQuery(GET_STUDENT_BY_SURNAME, getEntityClass())
                    .setParameter(VALUE, surname)
                    .getResultList();
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, LIST_OF_STUDENTS_EMPTY);
        }
        LOGGER.log(Level.INFO, GET_STUDENT_BY_SURNAME_SUCCESSFUL);
        return list;
    }

    @Override
    public List<Student> readByAddress(String address) {
        LOGGER.log(Level.INFO, START_GET_STUDENT_BY_ADDRESS);
        List<Student> list = new ArrayList<>();
        try {
            list = getEntityManager()
                    .createQuery(GET_STUDENT_BY_ADDRESS, getEntityClass())
                    .setParameter(VALUE, address)
                    .getResultList();
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, LIST_OF_STUDENTS_EMPTY);
        }
        LOGGER.log(Level.INFO, GET_STUDENT_BY_ADDRESS_SUCCESSFUL);
        return list;
    }

    @Override
    public List<Student> readByAge(int age) {
        LOGGER.log(Level.INFO, START_GET_STUDENT_BY_AGE);
        List<Student> list = new ArrayList<>();
        try {
            list = getEntityManager()
                    .createQuery(GET_STUDENT_BY_AGE, getEntityClass())
                    .setParameter(VALUE, age)
                    .getResultList();
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, LIST_OF_STUDENTS_EMPTY);
        }
        LOGGER.log(Level.INFO, GET_STUDENT_BY_AGE_SUCCESSFUL);
        return list;
    }

    @Override
    public List<Student> readByMark(int mark) {
        LOGGER.log(Level.INFO, START_GET_STUDENT_BY_MARK);
        List<Student> list = new ArrayList<>();
        try {
            list = getEntityManager()
                    .createQuery(GET_STUDENT_BY_MARK, getEntityClass())
                    .setParameter(VALUE, mark)
                    .getResultList();
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, LIST_OF_STUDENTS_EMPTY);
        }
        LOGGER.log(Level.INFO, GET_STUDENT_BY_MARK_SUCCESSFUL);
        return list;
    }
}
