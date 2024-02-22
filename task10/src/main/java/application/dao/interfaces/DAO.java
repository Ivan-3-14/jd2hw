package application.dao.interfaces;

public interface DAO<T> {

    void create(T object);

    T read(int id);

    T update(int id, T object);

    Integer delete(int id);

}
