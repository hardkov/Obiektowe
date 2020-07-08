package adapter;

public class SquarePegAdapter extends RoundPeg{
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg){
        super(0);
        this.peg = peg;
    }

    @Override
    public int getRadius(){
         double radius =  this.peg.getWidth() * Math.sqrt(2) / 2;
         int roundedRadius = (int) Math.ceil(radius);

         return roundedRadius;
    }
}
