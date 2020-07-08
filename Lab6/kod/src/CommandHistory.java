import java.util.ArrayList;

public class CommandHistory {
    private ArrayList<Command> history;

    public CommandHistory(){
        this.history = new ArrayList<>();
    }

    public void push(Command c){
        this.history.add(c);
    }

    public Command pop(){
        try{
            Command c = this.history.get(this.history.size() - 1);

            this.history.remove(this.history.size() - 1);

            return c;
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }
}
