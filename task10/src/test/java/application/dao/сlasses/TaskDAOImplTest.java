package application.dao.сlasses;

import application.dto.task.Task;
import application.utils.hibernate.HibernateUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import java.util.List;

import static application.dao.сlasses.utility.MockUtils.*;
import static application.utils.constants.ConstantContainer.*;

class TaskDAOImplTest {

    private final EntityManager entityManager = HibernateUtil.getEntityManager();
    private final TaskDAOImpl taskDAO = new TaskDAOImpl(entityManager);
    private final Task task1 = getTask1();
    private final Task task2 = getTask2();

    @BeforeEach
    void setUp() {
        taskDAO.create(task2);
    }

    @AfterEach
    void aVoid() {
    }

    @AfterClass
    public static void closeConnection() {
        HibernateUtil.close();
    }

    @Test
    void getEntityClass() {
        Assert.assertEquals(taskDAO.getEntityClass(), Task.class);
    }

    @Test
    void create() {
        Long countTaskBefore = getDataBaseCount(entityManager, task1);
        taskDAO.create(task1);
        Long countTaskAfter = getDataBaseCount(entityManager, task1);
        Assert.assertNotNull(countTaskAfter);
        Assert.assertEquals(java.util.Optional.of(countTaskBefore + 1), java.util.Optional.of(countTaskAfter));
        Task entityTask = taskDAO.read(2);
        assertTask(entityTask, task1);

    }

    @Test
    void read() {
        taskDAO.create(task1);
        taskDAO.create(task2);
        Task entityTask = taskDAO.read(3);
        assertTask(entityTask, task2);

        Assert.assertTrue(entityManager.isOpen());
        Assert.assertFalse(entityManager.getTransaction().isActive());
    }

    @Test
    void update() {
        taskDAO.update(2, task2);
        Task entityTask = taskDAO.read(2);
        assertTask(entityTask, task2);
    }

    @Test
    void delete() {
        Long countTaskBefore = getDataBaseCount(entityManager, task1);
        taskDAO.delete(1);
        Long countTaskAfter = getDataBaseCount(entityManager, task1);
        Assert.assertNotNull(countTaskBefore);
        Assert.assertEquals(java.util.Optional.of(countTaskBefore - 1), java.util.Optional.of(countTaskAfter));
    }

    @Test
    void getAllTaskByType() {
        int countTaskDB = Math.toIntExact(getDataBaseCount(entityManager, task1));
        List<Task> result = taskDAO.getAllTaskByType(TYPE_T);
        Assert.assertEquals(java.util.Optional.of(countTaskDB), java.util.Optional.of(result.size()));
    }
}