package application.dao.сlasses;

import application.dao.interfaces.DAO;
import application.dto.task.Task;

import javax.persistence.EntityManager;

public class TaskDAOImpl extends DAOImpl<Task> implements TaskDAO {

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
}
