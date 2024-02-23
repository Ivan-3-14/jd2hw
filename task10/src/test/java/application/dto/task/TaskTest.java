package application.dto.task;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static application.dao.сlasses.utility.MockUtils.getTask1;
import static application.dao.сlasses.utility.MockUtils.getTask2;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void builder() {
        Task task = Task.builder()
                .name("task name")
                .description("task description")
                .build();
        Task entityTask = Task.builder()
                .name("task name")
                .description("task description")
                .build();
        Assert.assertEquals("builder not equals", task, entityTask);
    }

    @Test
    void testToString() {
        Task task = Task.builder()
                .name("task name")
                .description("task description")
                .build();
        Assert.assertEquals("to string not equals",
                task.toString(),
                "Task(id=null, name=task name, description=task description)"
        );
    }

    @Test
    void setId() {
        Task task = Task.builder()
                .name("task name")
                .description("task description")
                .build();
        task.setId(2);
        Assert.assertEquals(task.getId(), 2, 0);
    }

    @Test
    void setName() {
        Task task = Task.builder()
                .name("task name")
                .description("task description")
                .build();
        task.setName("new name");
        Assert.assertEquals("set name not equals", task.getName(), "new name");
    }

    @Test
    void setDescription() {
        Task task = Task.builder()
                .name("task name")
                .description("task description")
                .build();
        task.setDescription("new description");
        Assert.assertEquals("set description not equals", task.getDescription(), "new description");
    }

    @Test
    void getId() {
        Task task = Task.builder()
                .name("task name")
                .description("task description")
                .build();
        task.setId(2);
        Assert.assertEquals(task.getId(), 2, 0);
    }

    @Test
    void getName() {
        Task task = Task.builder()
                .name("task name")
                .description("task description")
                .build();
        task.setName("new name");
        Assert.assertEquals("get name not equals", task.getName(), "new name");
    }

    @Test
    void getDescription() {
        Task task = Task.builder()
                .name("task name")
                .description("task description")
                .build();
        task.setDescription("new description");
        Assert.assertEquals("get description not equals", task.getDescription(), "new description");
    }
    @Test
    void testEquals() {
        Task task1 = getTask1();
        Task task2 = getTask1();
        Task task3 = getTask2();
        Assert.assertEquals(task1, task2);
        Assert.assertNotEquals(task1, task3);
        Assert.assertNotEquals(task2, null);
    }

    @Test
    void testHashCode() {
        Task task1 = getTask1();
        Task task2 = getTask1();
        Task task3 = getTask2();
        Assert.assertEquals(task1.hashCode(), task2.hashCode());
        Assert.assertNotEquals(task1.hashCode(), task3.hashCode());
    }
}