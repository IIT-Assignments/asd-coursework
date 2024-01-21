package Factory;

public interface IAppFactory {
    void create();
    void update();
    Object getById(int id);
    Object[] getAll();
    void delete();
}
