package application;

import application.address.Address;
import application.dao.сlasses.HomeTaskDAOImpl;
import application.dao.сlasses.TaskDAOImpl;
import application.dao.сlasses.WorkTaskDAOImpl;
import application.dto.hometask.HomeTask;
import application.dto.task.Task;
import application.dto.worktask.WorkTask;
import application.utils.hibernate.HibernateUtil;

import javax.persistence.EntityManager;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        TaskDAOImpl taskDAO = new TaskDAOImpl(entityManager);
        HomeTaskDAOImpl homeTaskDAO = new HomeTaskDAOImpl(entityManager);
        WorkTaskDAOImpl workTaskDAO = new WorkTaskDAOImpl(entityManager);

        Address address = Address
                .builder()
                .city("Minsk")
                .street("Nemiga")
                .build();

        Task task = new Task();
        task.setName("new task");
        task.setDescription("new description");
        taskDAO.create(task);

        HomeTask homeTask = new HomeTask();
        homeTask.setName("home task");
        homeTask.setDescription("home description");
        homeTask.setAddress(address);
        homeTaskDAO.create(homeTask);

        WorkTask workTask = new WorkTask();
        workTask.setName("work task");
        workTask.setDescription("work description");
        workTask.setCost(123.4);
        workTaskDAO.create(workTask);

        WorkTask workTask1 = workTaskDAO.read(3);
        workTask1.setCost(1.1);
        workTaskDAO.update(3, workTask1);

        entityManager.close();
        HibernateUtil.close();
    }
}
