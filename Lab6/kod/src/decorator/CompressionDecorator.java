package decorator;

import java.util.Arrays;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressionDecorator extends DataSourceDecorator{
    Deflater compresser;
    Inflater decompresser;

    public CompressionDecorator(DataSource s){
        super(s);
        this.compresser = new Deflater();
        this.decompresser = new Inflater();
    }

    @Override
    public void writeData(String data) {
        try{
            byte[] compressedBytes = new byte[1024];

            compresser.setInput(data.getBytes("UTF-8"));
            compresser.finish();
            int compressedBytesLength = compresser.deflate(compressedBytes);
            compresser.end();

            byte[] compressedBytesTrimmed = Arrays.copyOf(compressedBytes, compressedBytesLength);

            super.writeData(Base64.getEncoder().encodeToString(compressedBytesTrimmed));
        }
        catch (Exception e){
            System.out.println("decorator.CompressionDecorator writeData");
        }
    }

    @Override
    public String readData() {
        try{
            byte[] compressedData = Base64.getDecoder().decode(super.readData());
            byte[] decompressedData = new byte[1024];

            decompresser.setInput(compressedData, 0, compressedData.length);
            int decompressedDataLength = decompresser.inflate(decompressedData);
            decompresser.end();

            byte[] decompressedDataTrimmed = Arrays.copyOf(decompressedData, decompressedDataLength);

            return new String(decompressedDataTrimmed, "UTF-8");
        }
        catch (Exception e){
            System.out.println("decorator.CompressionDecorator readData" + e.getMessage());
        }

        return null;
    }
}
