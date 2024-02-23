package application.dao.сlasses;

import application.dto.hometask.HomeTask;
import application.dto.task.Task;
import application.dto.worktask.WorkTask;
import application.utils.hibernate.HibernateUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import java.sql.Timestamp;

import static application.dao.сlasses.utility.MockUtils.*;
import static application.dao.сlasses.utility.MockUtils.getDataBaseCount;

class DAOImplTest {

    private final EntityManager entityManager = HibernateUtil.getEntityManager();
    private final TaskDAOImpl taskDAO = new TaskDAOImpl(entityManager);
    private final Task task1 = getTask1();
    private final Task task2 = getTask2();
    private final HomeTask homeTask1 = getHomeTask1();
    private final WorkTask workTask1 = getWorkTask1();


    @BeforeEach
    void setUp() {
        taskDAO.create(task2);
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
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        homeTask1.setStartDate(startTime);
        homeTask1.setEndDate(endTime);

        taskDAO.create(task1);
        taskDAO.create(homeTask1);
        taskDAO.create(workTask1);

        Long countTaskAfter = getDataBaseCount(entityManager, task1);

        Assert.assertNotNull(countTaskAfter);

        Assert.assertEquals(java.util.Optional.of(countTaskBefore + 3), java.util.Optional.of(countTaskAfter));

        Task entityTask = taskDAO.read(2);
        HomeTask entityHomeTask = (HomeTask)  taskDAO.read(3);
        WorkTask entityWorkTask = (WorkTask) taskDAO.read(4);
        assertTask(entityTask, task1);
        assertWorkTask(entityWorkTask, workTask1);
        assertHomeTask(entityHomeTask, homeTask1);
    }

    @Test
    void read() {
        taskDAO.create(task1);
        taskDAO.create(task2);
        Task entityTask = taskDAO.read(3);
        assertTask(entityTask, task1);

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
}