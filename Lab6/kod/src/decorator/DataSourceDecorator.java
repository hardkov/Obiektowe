package decorator;

public class DataSourceDecorator implements DataSource{
    private DataSource wrappee;

    public DataSourceDecorator(DataSource s){
        this.wrappee = s;
    }

    public void writeData(String data){
        wrappee.writeData(data);
    }

    public String readData(){
        return wrappee.readData();
    }
}
