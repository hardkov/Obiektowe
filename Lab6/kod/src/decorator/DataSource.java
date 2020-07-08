package decorator;

public interface DataSource {
    void writeData(String Data);

    String readData();
}
