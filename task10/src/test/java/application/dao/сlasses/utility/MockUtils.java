package application.dao.сlasses.utility;

import application.address.Address;
import application.dto.hometask.HomeTask;
import application.dto.task.Task;
import application.dto.worktask.WorkTask;
import org.junit.Assert;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import static application.dao.сlasses.utility.MockConstant.*;

public class MockUtils {

    private MockUtils() {
    }

    public static Address getAddress1() {
        return Address.builder()
                .city(CITY1)
                .street(STREET1)
                .build();
    }

    public static Address getAddress2() {
        return Address.builder()
                .city(CITY2)
                .street(STREET2)
                .build();
    }

    public static Task getTask1() {
        Task task = new Task();
        task.setName(TASK_NAME1);
        task.setDescription(TASK_DESCRIPTION1);
        return task;
    }

    public static Task getTask2() {
        Task task = new Task();
        task.setName(TASK_NAME2);
        task.setDescription(TASK_DESCRIPTION2);
        return task;
    }

    public static WorkTask getWorkTask1() {
        WorkTask workTask = new WorkTask();
        workTask.setName(TASK_NAME1);
        workTask.setDescription(TASK_DESCRIPTION1);
        workTask.setCost(COST1);
        return workTask;
    }

    public static WorkTask getWorkTask2() {
        WorkTask workTask = new WorkTask();
        workTask.setName(TASK_NAME2);
        workTask.setDescription(TASK_DESCRIPTION2);
        workTask.setCost(COST2);
        return workTask;
    }

    public static HomeTask getHomeTask1() {
        HomeTask homeTask = new HomeTask();
        homeTask.setName(TASK_NAME1);
        homeTask.setDescription(TASK_DESCRIPTION1);
        homeTask.setAddress(getAddress1());
        return homeTask;
    }

    public static HomeTask getHomeTask2() {
        HomeTask homeTask = new HomeTask();
        homeTask.setName(TASK_NAME2);
        homeTask.setDescription(TASK_DESCRIPTION2);
        homeTask.setAddress(getAddress2());
        return homeTask;
    }

    public static Long getDataBaseCount(EntityManager entityManager, Object tClass) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> queryEntity = builder.createQuery(Long.class);
        queryEntity.select(builder.count(queryEntity.from(tClass.getClass())));
        return entityManager.createQuery(queryEntity).getSingleResult();
    }

    public static void  assertTask(Task entityTask, Task task) {
        Assert.assertNotNull(entityTask);
        Assert.assertEquals("name not equals", entityTask.getName(), task.getName());
        Assert.assertEquals("description not equals", entityTask.getDescription(), task.getDescription());
    }
    public static void  assertWorkTask(WorkTask entityTask, WorkTask task) {
        Assert.assertNotNull(entityTask);
        Assert.assertEquals("name not equals", entityTask.getName(), task.getName());
        Assert.assertEquals("description not equals", entityTask.getDescription(), task.getDescription());
        Assert.assertEquals("cost not equals", entityTask.getCost(), task.getCost());
    }
    public static void  assertHomeTask(HomeTask entityTask, HomeTask task) {
        Assert.assertNotNull(entityTask);
        Assert.assertEquals("name not equals", entityTask.getName(), task.getName());
        Assert.assertEquals("description not equals", entityTask.getDescription(), task.getDescription());
        Assert.assertEquals("start date not equals", entityTask.getStartDate(), task.getStartDate());
        Assert.assertEquals("end date not equals", entityTask.getEndDate(), task.getEndDate());
    }
}
