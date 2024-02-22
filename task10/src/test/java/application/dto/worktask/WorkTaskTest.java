package application.dto.worktask;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static application.dao.сlasses.utility.MockUtils.getWorkTask1;
import static application.dao.сlasses.utility.MockUtils.getWorkTask2;

class WorkTaskTest {

    @Test
    void testToString() {
        WorkTask entityWorkTask = getWorkTask1();
        Assert.assertEquals("to string not equals",
                entityWorkTask.toString(),
                "WorkTask(cost=16.7)"
        );
    }

    @Test
    void getCost() {
        WorkTask entityWorkTask = getWorkTask1();
        entityWorkTask.setCost(142.4);
        Assert.assertEquals(entityWorkTask.getCost(), 142.4, 0);
    }

    @Test
    void setCost() {
        WorkTask entityWorkTask = getWorkTask1();
        entityWorkTask.setCost(142.4);
        Assert.assertEquals(entityWorkTask.getCost(), 142.4, 0);
    }

    @Test
    void testEquals() {
        WorkTask workTask1 = getWorkTask1();
        WorkTask workTask2 = getWorkTask1();
        WorkTask workTask3 = getWorkTask2();
        Assert.assertEquals(workTask1, workTask2);
        Assert.assertNotEquals(workTask1, workTask3);
        Assert.assertNotEquals(workTask2, null);
    }

    @Test
    void testHashCode() {
        WorkTask workTask1 = getWorkTask1();
        WorkTask workTask2 = getWorkTask1();
        WorkTask workTask3 = getWorkTask2();
        Assert.assertEquals(workTask1.hashCode(), workTask2.hashCode());
        Assert.assertNotEquals(workTask1.hashCode(), workTask3.hashCode());
    }
}