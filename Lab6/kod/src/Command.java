import java.util.ArrayList;

public class Command {
    protected Application app;
    protected Editor editor;
    private ArrayList<String> backup;

    public Command(Application app, Editor editor){
        this.app = app;
        this.editor = editor;
        this.backup = new ArrayList<>();
    }

    public void saveBackup(){
        this.backup.add(this.editor.getText());
    }

    public void undo(){
        try{
            String text = this.backup.get(backup.size() - 1);

            this.editor.setText(text);

            this.backup.remove(this.backup.size() - 1);
        }
        catch (IndexOutOfBoundsException e){
        }
    }

    public void execute(){
    }
}
