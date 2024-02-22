package application.dao.сlasses;

import application.dao.interfaces.DAO;
import application.dto.task.Task;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static application.utils.constants.ConstantContainer.GET_ALL_QUERY;

public class TaskDAOImpl extends DAOImpl<Task> implements DAO<Task> {

    public TaskDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Task> getEntityClass() {
        return Task.class;
    }

    @Override
    public void create(Task task) {
        super.create(task);
    }

    @Override
    public Task read(int id) {
        return super.read(id);
    }

    @Override
    public Task update(int id, Task task) {
        return super.update(id, task);
    }

    @Override
    public Integer delete(int id) {
        return super.delete(id);
    }

    public List<Task> getAllTaskByType(String A) {
        List<Task> result = new ArrayList<>();
        EntityManager entityManager = getEntityManager();
        String query = String.format("%s%s", GET_ALL_QUERY, A);
        if (entityManager.isOpen()) {
            entityManager.getTransaction().begin();
            result = entityManager.createQuery(query, getEntityClass()).getResultList();
            entityManager.getTransaction().commit();
        }
        return result;
    }
}
