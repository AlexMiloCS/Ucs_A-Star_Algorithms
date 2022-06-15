import java.util.Random;


public class Labyrinth{
    private int[][] lab;
    private int arraySize;

    public Labyrinth(int arraySize) {
        Random rand = new Random();
        this.arraySize=arraySize;
        int max = 4;
        lab = new int[arraySize][arraySize];
        for(int i= 0; i<arraySize ;i++){
            for(int j= 0; j<arraySize ;j++){
                //Random number from 0.0-1.0 
                float p=rand.nextFloat();
                //Random number from 0-3 adding 1 is random number from 1-4
                int value = rand.nextInt(max)+1;
                if(p<=0.1){
                    lab[i][j]=-1;
                }  
                else{
                    lab[i][j]=value;
                }  
            }
        }
    }

    public void printLabyrinth(int x , int y , int x1 , int y1, int x2 , int y2){
        for(int i= 0; i<arraySize ;i++){
            for(int j= 0; j<arraySize ;j++){
                if(i==x && j==y){
                    System.out.print("{S "+lab[i][j]+"} ,");
                }
                else if(i==x1 && j==y1){
                    System.out.print("{G1 "+lab[i][j]+ "} ,");
                }
                else if(i==x2 && j==y2){
                    System.out.print("{G2 "+lab[i][j]+ "} ,");     
                }
                else if(lab[i][j]==-1){
                    System.out.print("{---} ,");
                }
                else{
                    System.out.print("{"+lab[i][j]+ "} ,");
                }
            }
            System.out.print("\n");
        }

    }

    public void printLabyrinth(){
        for(int i= 0; i<arraySize ;i++){
            for(int j= 0; j<arraySize ;j++){
                if(lab[i][j]==-1){
                    System.out.print("{---} ,");
                }
                else{
                    System.out.print("{"+lab[i][j]+ "} ,");
                }
            }
            System.out.print("\n");
        }
    }

    public int getValue(int x,int y){
        return lab[x][y];
    }

    public int getArraySize() {
        return arraySize;
    }
}