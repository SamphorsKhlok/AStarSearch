import java.util.*;
import java.util.PriorityQueue;

public class AStar {
    //initial with 5x5
    public Cell[][] grid = new Cell[5][5];
    public boolean closed[][];
    public int startX, startY;
    public int endX, endY;
    public int x; // size row
    public int y; // size col
    
    public PriorityQueue<Cell> open;
    
    public AStar(Cell[][] grid, int startX, int startY, int endX, int endY) {
    		this.grid = grid;
    		this.x = this.grid.length;
    		this.y = this.grid[0].length;
    		this.closed = new boolean[x][y];
    		
    		this.startX = startX;
    		this.startY = startY;
    		
    		this.endX = endX;
    		this.endY = endY;
    		
    		this.open = new PriorityQueue<>((Object o1, Object o2) -> {
    	        Cell c1 = (Cell)o1;
    	        Cell c2 = (Cell)o2;
    	        
    	        if(c1.totalEngery < c2.totalEngery) return -1;
    	        if(c1.totalEngery > c2.totalEngery) return 1;
    	        
    	        return 0;
    	        }
    	    );
    }
    
    public void CalculateEngery(Cell current, Cell t, int total){
        if(t == null || closed[t.i][t.j]) {
        		return;
        }
        
        int t_new_total = t.energy + total ;
        
        boolean inOpen = open.contains(t);
        if(!inOpen || t_new_total < t.totalEngery){
            t.totalEngery = t_new_total;
            t.parent = current;
            if(!inOpen) {
            		open.add(t);
            }
        }
    }
    
    public void Search(){ 
        //System.out.println(this.grid[startX][startY]);
        //add the start location to open list.
    		open.add(this.grid[startX][startY]);
        
        Cell current;
        
        while(true){ 
            current = open.poll();
            //System.out.println(current);
            
            if(current == null) break;
            closed[current.i][current.j]=true; 

            if(current.equals(grid[endX][endY])){
                return; 
            } 

            Cell t;  
            
            if(current.i-1>=0){
            		//System.out.println("back");
                t = grid[current.i-1][current.j];
                CalculateEngery(current, t, current.totalEngery);
            } 

            if(current.j-1>=0){
            		//System.out.println("up");
                t = grid[current.i][current.j-1];
                CalculateEngery(current, t, current.totalEngery);
            }

            if(current.j+1<grid[0].length){
            		//.out.println("down");
                t = grid[current.i][current.j+1];
                CalculateEngery(current, t, current.totalEngery);
            }

            if(current.i+1<grid.length){
            		//System.out.println("front");
                t = grid[current.i+1][current.j];
                CalculateEngery(current, t, current.totalEngery); 
            }
        }
        
    }
    
    public void Display() {
    		System.out.println("\nGrid : ");
    		
        for(int i = 0;i<x;++i){
            for(int j = 0;j<x;++j){
                	System.out.printf("%-3d ", grid[i][j].energy);
            }
            System.out.println();
        }
        
        System.out.println();
         
        //reach the end
        if(closed[endX][endY]){
             System.out.print("Path: ");
             Cell current = grid[endX][endY];
             System.out.print(current);
             
             while(current.parent!=null){
                 System.out.print(" -> "+current.parent);
                 current = current.parent;
             } 
        }else {
        		System.out.println("No possible path");
        }
    }
}
