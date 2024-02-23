package application.dao.сlasses;

import application.dao.interfaces.HomeTaskDAO;
import application.dto.hometask.HomeTask;

import javax.persistence.EntityManager;

public class HomeTaskDAOImpl extends DAOImpl<HomeTask> implements HomeTaskDAO {

    public HomeTaskDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<HomeTask> getEntityClass() {
        return HomeTask.class;
    }

    @Override
    public void create(HomeTask homeTask) {
        super.create(homeTask);
    }

    @Override
    public HomeTask read(int id) {
        return super.read(id);
    }

    @Override
    public HomeTask update(int id, HomeTask homeTask) {
        return super.update(id, homeTask);
    }

    @Override
    public Integer delete(int id) {
        return super.delete(id);
    }
}
