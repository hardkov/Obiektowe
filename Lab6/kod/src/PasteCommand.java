public class PasteCommand extends Command{
    public PasteCommand(Application app, Editor editor){
        super(app, editor);
    }

    public void execute(){
        super.saveBackup();

        String text = this.app.getClipboard();

        this.editor.replaceSelection(text);
    }
}
