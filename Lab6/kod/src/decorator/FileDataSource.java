package decorator;

import java.io.*;
import java.util.Arrays;


public class FileDataSource implements DataSource{
    private String filename;

    public FileDataSource(String filename){
        this.filename = filename;
    }

    public void writeData(String data){
        try{
            File file = new File(filename);
            OutputStream os = new FileOutputStream(file);
            os.write(data.getBytes("UTF-8"));
            os.close();
            System.out.println("Successfully wrote to the file");
        }
        catch (Exception e){
            System.out.println("decorator.FileDataSource writeData" + e.getMessage());
        }
    }

    public String readData(){
        try{
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[1024];

            int bytesRead = fis.read(data);
            fis.close();

            byte[] dataTrimmed = Arrays.copyOf(data, bytesRead);

            return new String(dataTrimmed, "UTF-8");
        }
        catch (Exception e){
            System.out.println("File error");
        }

        return null;
    }
}
