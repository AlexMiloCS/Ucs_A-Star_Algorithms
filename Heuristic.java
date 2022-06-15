public class Heuristic {
    private int g1x;
    private int g1y;
    private int g2x;
    private int g2y;

    public Heuristic(int g1x,int g1y,int g2x,int g2y){
        this.g1x=g1x;
        this.g1x=g1y;
        this.g2x=g2x;
        this.g2y=g2y;
    }
    public double findCost(int x,int y){
        double a=0;
        double b=0;
        double c=0;
        double d=0;
        
        if(x-g1x<0){
            if(y-g1y<0){
                a=g1x-x;
                b=g1y-y;
            }
            else{
                a=g1x-x;
                b=y-g1y;
            }
        }
        else{
            if(y-g1y<0){
                a=x-g1x;
                b=g1y-y;
            }
            else{
                a=x-g1x;
                b=y-g1y;
            }
        }
        if(x-g2x<0){
            if(y-g2y<0){
                c=g2x-x;
                d=g2y-y;
            }
            else{
                c=g2x-x;
                d=y-g2y;
            }
        }
        else{
            if(y-g2y<0){
                c=x-g2x;
                d=g2y-y;
            }
            else{
                c=x-g2x;
                d=y-g2y;
            }
        }
        double g1 = calcCost(a,b);
        double g2 = calcCost(c,d);
        double cost=0;
        if(g1>g2){
            cost = g2;
        }
        else{
            cost = g1;
        }
        return cost;
    }


    public double calcCost(double a , double b){
        double straight=0;
        double diagonal=0;

        if(a>b){
            straight=a-b;
            diagonal=a-straight;
        }
        else{
            straight=b-a;
            diagonal=b-straight;
        }
        return (diagonal*0.5 + straight);
    }
}
