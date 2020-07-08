package decorator;

public class EncryptionDecorator extends DataSourceDecorator{
    private String secretKey = "superkluczasdasdasd";

    public EncryptionDecorator(DataSource s){
        super(s);
    }

    @Override
    public void writeData(String data) {
        String encryptedData = AES.encrypt(data, this.secretKey);
        super.writeData(encryptedData);
    }

    @Override
    public String readData() {
        String encryptedData = super.readData();
        return AES.decrypt(encryptedData, this.secretKey);
    }
}
