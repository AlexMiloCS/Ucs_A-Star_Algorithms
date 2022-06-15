

public class Node {
    private double totalCost;
    private double pathCost;
    private String path;
    private int [][] neighbours;
    private int posX;
    private int posY;
    private Node parent;
    private double value;
    private int arraySize;
    private Labyrinth lab;
    private int rows=0;
    private double movementCost;
    private String name;


    public Node(Labyrinth lab,int x, int y, Node parent, String name){
        posX = x;
        posY = y;
        this.lab=lab;
        this.parent=parent;
        this.name=name;
        arraySize=lab.getArraySize();
        findNeighbours();
        if(!(parent==null)){
            path = parent.getPath()+" , "+ name;
            Movement move= new Movement(parent.getX(), parent.getY(), x, y);
            movementCost = move.movementCost(lab);
            pathCost = parent.getPathCost()+movementCost;
        }
        else{
            path = name;
            movementCost=0;
            pathCost = 0;
        }
    }
    public Node(Labyrinth lab,int x, int y, Node parent, String name, double h){
        posX = x;
        posY = y;
        this.lab=lab;
        this.parent=parent;
        this.name=name;
        arraySize=lab.getArraySize();
        findNeighbours();
        if(!(parent==null)){
            path = parent.getPath()+" , "+ name;
            Movement move= new Movement(parent.getX(), parent.getY(), x, y);
            movementCost = move.movementCost(lab);
            pathCost = parent.getPathCost()+movementCost;
            totalCost = parent.getPathCost()+movementCost + h;
        }
        else{
            path = name;
            movementCost=0;
            pathCost = 0;
            totalCost = h;
        }
    }
    

    public void findNeighbours(){
        int startPosX = (posX - 1 < 0) ? posX : posX-1;
        int startPosY = (posY - 1 < 0) ? posY : posY-1;
        int endPosX =   (posX + 1 > arraySize-1) ? posX : posX+1;
        int endPosY =   (posY + 1 > arraySize-1) ? posY : posY+1;

        int neighbour[][]= new int [8][2];  
        rows=0;

        for (int rowNum=startPosX; rowNum<=endPosX; rowNum++) {
            for (int colNum=startPosY; colNum<=endPosY; colNum++) {
                if(!(rowNum==posX && colNum==posY)){
                    if(lab.getValue(rowNum,colNum)!=(-1)){
                        neighbour[rows][0]=rowNum;
                        neighbour[rows][1]=colNum;
                        rows++;
                    }
                }
            }
        }
        neighbours = new int[rows][2];
        for(int i=0; i<rows; i++){
            for(int j=0; j<2; j++){
                neighbours[i][j]=neighbour[i][j];
            }
        }
    }
    public int getNeighbourRows(){
        return rows;
    }

    public int getNeighbourX(int i) {
        return neighbours[i][0];
    }
    public int getNeighbourY(int i) {
        return neighbours[i][1];
    }

    public String getPath() {
        return path;
    }
    public double getPathCost() {
        return pathCost;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public int getX(){
        return posX;
    }
    public int getY(){
        return posY;
    }

    public String getName() {
        return name;
    }
}
