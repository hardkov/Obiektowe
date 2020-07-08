public class Editor {
    private String text;
    private int startIndex;
    private int endIndex;

    public Editor(String text){
        this.text = text;
        this.startIndex = 0;
        this.endIndex = -1;
    }

    public String getSelection(){
        try{
            return this.text.substring(startIndex, endIndex);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        return "";
    }

    public void deleteSelection(){
        try{
            this.text = this.text.substring(0, startIndex) + this.text.substring(endIndex);
        }
        catch (IndexOutOfBoundsException e){
        }

        this.startIndex = 0;
        this.endIndex = -1;
    }

    public void replaceSelection(String text){
        try{
            this.text = this.text.substring(0, startIndex) + text + this.text.substring(endIndex);
        }
        catch (IndexOutOfBoundsException e){
        }

        this.startIndex = 0;
        this.endIndex = -1;
    }

    public void setText(String text){
        this.text = text;
        this.startIndex = 0;
        this.endIndex = -1;
    }

    public void setSelection(int startIndex, int endIndex){
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public String getText() {
        return text;
    }
}
