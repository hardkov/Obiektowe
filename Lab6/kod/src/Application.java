public class Application {
    private Editor[] editors;
    private Editor activeEditor;
    private String clipboard;
    private CommandHistory history;

    public Application(){
        this.history = new CommandHistory();
    }

    public void executeCommand(Command c){
        c.execute();
        this.history.push(c);
    }

    public void undo(){
        Command c = history.pop();
        c.undo();
    }

    public void setClipboard(String clipboard){
        this.clipboard = clipboard;
    }

    public String getClipboard(){
        return this.clipboard;
    }
}
