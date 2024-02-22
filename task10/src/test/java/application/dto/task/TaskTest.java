package application.dto.task;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static application.dao.сlasses.utility.MockUtils.*;

class TaskTest {

    @Test
    void testToString() {
        Task task = getTask1();
        Assert.assertEquals("to string not equals",
                task.toString(),
                "Task(id=null, name=task1, description=description1)"
        );
    }

    @Test
    void setId() {
        Task task = getTask1();
        task.setId(2);
        Assert.assertEquals(task.getId(), 2, 0);
    }

    @Test
    void setName() {
        Task task = getTask1();
        task.setName("new name");
        Assert.assertEquals("set name not equals", task.getName(), "new name");
    }

    @Test
    void setDescription() {
        Task task = getTask1();
        task.setDescription("new description");
        Assert.assertEquals("set description not equals", task.getDescription(), "new description");
    }

    @Test
    void getId() {
        Task task = getTask1();
        task.setId(2);
        Assert.assertEquals(task.getId(), 2, 0);
    }

    @Test
    void getName() {
        Task task = getTask1();
        task.setName("new name");
        Assert.assertEquals("get name not equals", task.getName(), "new name");
    }

    @Test
    void getDescription() {
        Task task = getTask1();
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