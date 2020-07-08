public class CutCommand extends Command{
    public CutCommand(Application app, Editor editor){
        super(app, editor);
    }

    public void execute(){
        super.saveBackup();

        String text = this.editor.getSelection();

        this.editor.deleteSelection();
        this.app.setClipboard(text);
    }
}
