package group.six.adventurexp.repositories.interfaces;

import java.util.List;

public interface IRepository<T>
{
    boolean create(T newItem);

    T read(int id);

    List<T> readAll();

    boolean update(T item);

    boolean delete(int id);
}
