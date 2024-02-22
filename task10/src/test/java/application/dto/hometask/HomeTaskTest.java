package application.dto.hometask;

import application.address.Address;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static application.dao.сlasses.utility.MockUtils.*;

class HomeTaskTest {

    @Test
    void testToString() {
        HomeTask homeTask = getHomeTask1();
        Assert.assertEquals("to string not equals",
                homeTask.toString(),
                "HomeTask(startDate=null, endDate=null, address=Address(street=new street, city=new city))");
    }

    @Test
    void getStartDate() {
        HomeTask homeTask = getHomeTask1();
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        homeTask.setStartDate(startTime);
        Assert.assertEquals(homeTask.getStartDate(), startTime);
    }

    @Test
    void getEndDate() {
        HomeTask homeTask = getHomeTask1();
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        homeTask.setEndDate(endTime);
        Assert.assertEquals(homeTask.getEndDate(), endTime);
    }

    @Test
    void getAddress() {
        HomeTask homeTask = getHomeTask1();
        Address address = getAddress2();
        homeTask.setAddress(address);
        Assert.assertEquals("get address not equals", homeTask.getAddress(), address);
    }

    @Test
    void setStartDate() {
        HomeTask homeTask = getHomeTask1();
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        homeTask.setStartDate(startTime);
        Assert.assertEquals(homeTask.getStartDate(), startTime);
    }

    @Test
    void setEndDate() {
        HomeTask homeTask = getHomeTask1();
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        homeTask.setEndDate(endTime);
        Assert.assertEquals(homeTask.getEndDate(), endTime);
    }

    @Test
    void setAddress() {
        HomeTask homeTask = getHomeTask1();
        Address address = getAddress2();
        homeTask.setAddress(address);
        Assert.assertEquals("set address not equals", homeTask.getAddress(), address);
    }

    @Test
    void testEquals() {
        HomeTask homeTask1 = getHomeTask1();
        HomeTask homeTask2 = getHomeTask1();
        HomeTask homeTask3 = getHomeTask2();
        Assert.assertEquals(homeTask1, homeTask2);
        Assert.assertNotEquals(homeTask1, homeTask3);
        Assert.assertNotEquals(homeTask2, null);
    }

    @Test
    void testHashCode() {
        HomeTask homeTask1 = getHomeTask1();
        HomeTask homeTask2 = getHomeTask1();
        HomeTask homeTask3 = getHomeTask2();
        Assert.assertEquals(homeTask1.hashCode(), homeTask2.hashCode());
        Assert.assertNotEquals(homeTask1.hashCode(), homeTask3.hashCode());
    }
}