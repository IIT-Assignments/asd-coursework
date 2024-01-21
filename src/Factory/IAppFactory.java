package Factory;

public interface IAppFactory {
    void create();
    void update(int id);
    Object getById(int id);
    void getAll();
    void delete();

    int generateId();
}
