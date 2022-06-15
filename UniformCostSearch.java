import java.util.HashMap;


public class UniformCostSearch {
    private HashMap<String,Node> openNodes = new HashMap<String,Node>();
    private HashMap<String,String> closedNodes = new HashMap<String,String>();
    private String expansion;
    private Labyrinth lab;
    private int sx; 
    private int sy;
    private int g1x;
    private int g1y;
    private int g2x;
    private int g2y;

    public UniformCostSearch(Labyrinth lab,int sx,int sy,int g1x,int g1y,int g2x,int g2y){
        this.lab=lab;
        this.sx =sx;
        this.sy=sy;
        this.g1x=g1x;
        this.g1y=g1y;
        this.g2x=g2x;
        this.g2y=g2y;
    }

    public void startUCS(){
        Node s = new Node(lab, sx, sy, null, Name(sx, sy));
        openNodes.put(s.getName(),s);
        expansion= s.getName();
        createTree(s);
        doTheUCS(s);
    }
    public void doTheUCS(Node prev){
        double cost=prev.getPathCost();
        Node   next = prev;
        while(openNodes.size()>0){
           for(String key : openNodes.keySet()){
                Node cur = openNodes.get(key);
                if(cost==prev.getPathCost()){
                    if(next==prev){
                        cost = cur.getPathCost();
                        next = cur;
                    }
                    
                }
                else if(cost>cur.getPathCost()){
                    cost = cur.getPathCost();
                    next = cur;
                }
                
           }
           expansion += " " + next.getName();
           createTree(next);
           doTheUCS(next);
        }
    }

    public void createTree(Node a){
        if(a.getName().equals(Name(g1x, g1y))){
            openNodes.clear();
            printPath("G1",a);
            return;
        }
        else if(a.getName().equals(Name(g2x, g2y))){
            openNodes.clear();
            printPath("G2",a);
            return;
        }
        closedNodes.put(a.getName(),a.getPath());
        openNodes.remove(a.getName());
        int nRows = a.getNeighbourRows();
        for(int i=0;i<nRows;i++){
                int x = a.getNeighbourX(i);
                int y = a.getNeighbourY(i);
                Node cur = new Node(lab, x, y, a, Name(x, y));
                if(!closedNodes.containsKey(Name(x, y))){
                    if(!openNodes.containsKey(Name(x, y))){
                        openNodes.put(Name(x, y), cur);
                    }
                    else{
                        Node prev = openNodes.get(Name(x, y));
                        if(cur.getPathCost() < prev.getPathCost()){
                            openNodes.replace(Name(x, y),cur,prev);
                        }
                    }                    
                }           
        }
        return;
    }

    private void printPath(String end, Node a) {
        System.out.println("The algorithm expanded on:"+ expansion);
        System.out.println("Path = S:"+a.getPath()+":"+end+"\n"+"Cost of Path = "+a.getPathCost());
        return;
    }

    public String Name(int x, int y){
       return ("("+x+","+y+")");
    }
}


