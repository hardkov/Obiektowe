public class Main {
    public static void main(String[] args){
        Application app = new Application();
        Editor editor = new Editor("to jest tekst");

        CopyCommand command = new CopyCommand(app, editor);
        editor.setSelection(0, 2);
        app.executeCommand(command);
        System.out.println(editor.getText());

        editor.setSelection(3, 6);
        PasteCommand command1 = new PasteCommand(app, editor);
        app.executeCommand(command1);
        System.out.println(editor.getText());

        editor.setSelection(0, 4);
        CutCommand command2 = new CutCommand(app, editor);
        app.executeCommand(command2);
        System.out.println(editor.getText());

        app.undo();
        System.out.println(editor.getText());

        app.undo();
        System.out.println(editor.getText());
    }
}
