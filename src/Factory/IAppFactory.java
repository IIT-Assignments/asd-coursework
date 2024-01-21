package Factory;

public interface IAppFactory {
    void create();
    void update(int id);
    Object getById(int id);
    Object[] getAll();
    void delete(int id);

    int generateId();
}
