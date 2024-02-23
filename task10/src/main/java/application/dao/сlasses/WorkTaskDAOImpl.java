package application.dao.сlasses;

import application.dao.interfaces.WorkTaskDAO;
import application.dto.worktask.WorkTask;

import javax.persistence.EntityManager;

public class WorkTaskDAOImpl extends DAOImpl<WorkTask> implements WorkTaskDAO {

    public WorkTaskDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<WorkTask> getEntityClass() {
        return WorkTask.class;
    }

    @Override
    public void create(WorkTask workTask) {
        super.create(workTask);
    }

    @Override
    public WorkTask read(int id) {
        return super.read(id);
    }

    @Override
    public WorkTask update(int id, WorkTask workTask) {
        return super.update(id, workTask);
    }

    @Override
    public Integer delete(int id) {
        return super.delete(id);
    }
}
