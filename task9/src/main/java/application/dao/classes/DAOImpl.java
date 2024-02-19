package application.dao.classes;

import application.dao.interfaces.DAO;
import application.utils.functinterface.MyInterfaceToDAO;
import application.utils.hibernate.HibernateUtil;
import application.utils.printer.Printer;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.Arrays;

import static application.utils.functinterface.UtilsInterface.superMethodInterface;
import static application.utils.printer.Printer.*;

public abstract class DAOImpl<T> implements DAO<T> {

    private EntityManager entityManager;

    public DAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public abstract Class<T> getEntityClass();

    public void create(T object) {
        if (object != null) {
            checkEntityManager();
            MyInterfaceToDAO betweenBeginAndCommitted = () -> {
                entityManager.persist(object);
                return object;
            };
            superMethodInterface(betweenBeginAndCommitted, entityManager);
            printSuccessfulSaveMethodMessage();
        } else {
            printNullPointerMessage();
        }
    }

    public T read(int id) {
        T object = startMethod(id);
        MyInterfaceToDAO betweenBeginAndCommitted = () -> object;
        superMethodInterface(betweenBeginAndCommitted, entityManager);
        return object;
    }

    public T update(int id, T object) {
        T result = startMethod(id);
        if (result != null) {
            MyInterfaceToDAO betweenBeginAndCommitted = () -> {
                Field[] objFields = getEntityClass().getDeclaredFields();
                Arrays.stream(objFields)
                        .peek(q -> q.setAccessible(true))
                        .filter(field -> field.isAnnotationPresent(Column.class))
                        .forEach(field -> {
                            try {
                                field.set(result, field.get(object));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        });

                entityManager.merge(result);
                return result;
            };
            superMethodInterface(betweenBeginAndCommitted, entityManager);
            printSuccessfulUpdateMethodMessage();
        }
        return result;
    }

    public Integer delete(int id) {
        T object = startMethod(id);
        if (object != null) {
            MyInterfaceToDAO betweenBeginAndCommitted = () -> {
                entityManager.remove(object);
                return object;
            };
            superMethodInterface(betweenBeginAndCommitted, entityManager);
            printSuccessfulDeleteMethodMessage();
        }
        return id;
    }

    private void checkEntityManager() {
        if (!entityManager.isOpen()) {
            entityManager = HibernateUtil.getEntityManager();
        }
    }

    private T startMethod(int id) {
        checkEntityManager();
        T object = entityManager.find(getEntityClass(), id);
        if (checkFindById(object)) {
            return null;
        }
        return object;
    }

    private boolean checkFindById(T object) {
        if (null == object) {
            Printer.printNotFoundMessage();
            return true;
        }
        return false;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
