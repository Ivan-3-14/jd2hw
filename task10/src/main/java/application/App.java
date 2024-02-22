package application;

import application.address.Address;
import application.dao.сlasses.TaskDAOImpl;
import application.dto.hometask.HomeTask;
import application.dto.task.Task;
import application.utils.hibernate.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

import static application.utils.constants.ConstantContainer.*;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        TaskDAOImpl taskDAO = new TaskDAOImpl(entityManager);
        Address address = Address
                .builder()
                .city("Minsk")
                .street("Nemiga")
                .build();

        Task task = Task.builder()
                .name("new task")
                .description("new description")
                .build();
        taskDAO.create(task);

        HomeTask homeTask = new HomeTask();
        homeTask.setName("2 task");
        homeTask.setDescription("2 description");
        homeTask.setAddress(address);
        taskDAO.create(homeTask);

        List<Task> result = taskDAO.getAllTaskByType(TYPE_H);
        result.forEach(System.out::println);

        entityManager.close();
        HibernateUtil.close();
    }
}
