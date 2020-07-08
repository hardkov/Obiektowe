public class CopyCommand extends Command{
    public CopyCommand(Application app, Editor editor){
        super(app, editor);
    }

    @Override
    public void execute() {
        this.app.setClipboard(this.editor.getSelection());
    }
}
