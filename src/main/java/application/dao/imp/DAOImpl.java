package application.dao.imp;

import application.dao.interfaces.DAO;
import application.utils.reflection.ReflectionUtils;

import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import static application.utils.constant.ConstantContainer.*;

public abstract class DAOImpl<T> implements DAO<T> {

    private static final Logger LOGGER = Logger.getLogger(DAOImpl.class.getName());
    private final EntityManager entityManager;

    protected DAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public abstract Class<T> getEntityClass();

    public T create(T object) {
        if (object == null) {
            LOGGER.log(Level.INFO, NULL_POINTER_MESSAGE);
        }
        entityManager.persist(object);
        LOGGER.log(Level.INFO, SAVE_SUCCESSFUL);

        return object;
    }

    public T read(int id) {
        T object = entityManager.find(getEntityClass(), id);
        if (object == null) {
            LOGGER.log(Level.INFO, NULL_POINTER_MESSAGE);
        }
        return object;
    }

    public T update(int id, T object) {
        T result = read(id);
        if (result != null) {
            ReflectionUtils.updateReflection(object, result, entityManager);
            LOGGER.log(Level.INFO, UPDATE_SUCCESSFUL);
        }
        return result;
    }

    public Integer delete(int id) {
        T result = read(id);
        if (result == null) {
            LOGGER.log(Level.INFO, DELETE_NOT_FOUND);
        }
        entityManager.remove(result);
        LOGGER.log(Level.INFO, DELETE_SUCCESSFUL);
        return id;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}

