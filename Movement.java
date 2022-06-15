public class Movement {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean typeOfMovement;
    public Movement(int x1, int y1,int x2, int y2){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        if(x1==x2 ||y1==y2){
            typeOfMovement= true;
        }
        else{
            typeOfMovement= false;
        }
    }
    public double movementCost(Labyrinth lab){
        double cost=0;
        int val1 =lab.getValue(x1,y1);
        int val2 =lab.getValue(x2,y2);
        if(typeOfMovement){
            if(val1>=val2){
                cost=val1-val2+1;
            }
            else{
                cost=val2-val1+1;
            }
        }
        else{
            if(val1>=val2){
                cost=val1-val2+0.5;
            }
            else{
                cost=val2-val1+0.5;
            }
        }
        return cost;
    }
    
}
