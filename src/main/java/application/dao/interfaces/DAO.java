package application.dao.interfaces;

public interface DAO<T> {

    T create(T object);

    T read(int id);

    T update(int id, T object);

    Integer delete(int id);

    Class<T> getEntityClass();
}
