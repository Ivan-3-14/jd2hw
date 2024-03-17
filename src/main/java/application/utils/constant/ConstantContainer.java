package application.utils.constant;

public class ConstantContainer {

    public static final String GET_ALL_STUDENT_QUERY = "select s from Student s";
    public static final String GET_STUDENT_BY_NAME = "select s from Student s where name = :value";
    public static final String GET_STUDENT_BY_SURNAME = "select s from Student s where surname = :value";
    public static final String GET_STUDENT_BY_ADDRESS = "select s from Student s where address = :value";
    public static final String GET_STUDENT_BY_AGE = "select s from Student s where age = :value";
    public static final String GET_STUDENT_BY_MARK = "select s from Student s where mark = :value";

    public static final String LIST_OF_STUDENTS_EMPTY = "list of students is empty";

    public static final String START_CREATE = "Запущен метод create";
    public static final String START_READ = "Запущен метод read";
    public static final String START_UPDATE = "Запущен метод update";
    public static final String START_DELETE = "Запущен метод delete";

    public static final String SAVE_SUCCESSFUL = " save successful ";
    public static final String UPDATE_SUCCESSFUL = " update successful ";
    public static final String DELETE_SUCCESSFUL = " delete successful ";
    public static final String DELETE_NOT_FOUND = "Delete failed. Not found";
    public static final String NULL_POINTER_MESSAGE = "this is null";

    public static final String START_GET_ALL_STUDENT = "Запущен метод getAllStudents";
    public static final String START_GET_STUDENT_BY_NAME = "Запущен метод readByName Students";
    public static final String START_GET_STUDENT_BY_SURNAME = "Запущен метод readBySurname Students";
    public static final String START_GET_STUDENT_BY_ADDRESS = "Запущен метод readByAddress Students";
    public static final String START_GET_STUDENT_BY_AGE = "Запущен метод readByAge Students";
    public static final String START_GET_STUDENT_BY_MARK = "Запущен метод readByMark Students";

    public static final String GET_ALL_STUDENT_SUCCESSFUL = "getAllStudents successful";
    public static final String GET_STUDENT_BY_NAME_SUCCESSFUL = "readByName Students successful";
    public static final String GET_STUDENT_BY_SURNAME_SUCCESSFUL = "readBySurname Students successful";
    public static final String GET_STUDENT_BY_ADDRESS_SUCCESSFUL = "readByAddress Students successful";
    public static final String GET_STUDENT_BY_AGE_SUCCESSFUL = "readByAge Students successful";
    public static final String GET_STUDENT_BY_MARK_SUCCESSFUL = "readByMark Students successful";

    public static final String VALUE = "value";

    private ConstantContainer() {
    }
}
