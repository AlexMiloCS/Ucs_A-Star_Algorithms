import java.util.*;


public class Project {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give array size");
        int arraySize = in.nextInt();
        System.out.println("arraysize is: " + arraySize); 
        Labyrinth lab =new Labyrinth(arraySize);
        lab.printLabyrinth();
        System.out.println("Enter Coordinates for S");
        int x = in.nextInt();
        int y = in.nextInt();   

        System.out.println("Enter Position for G1");
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        System.out.println("Enter Position for G2");
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        if(lab.getValue(x1,y1)==-1 || lab.getValue(x2,y2)==-1){
            System.out.println("Coordinates on blocked cell");
            System.exit(0);
        }
        in.close();
        lab.printLabyrinth(x,y,x1,y1,x2,y2);

        System.out.println("algorithm is: UCS");
        UniformCostSearch ucs= new UniformCostSearch(lab,x,y,x1,y1,x2,y2);
        ucs.startUCS();
        System.out.println("algorithm is: A*");
        A_Star a = new A_Star(lab,x,y,x1,y1,x2,y2);  
        a.startA_Star();   
    }
}
