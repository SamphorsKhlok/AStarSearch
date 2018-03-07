import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception{ 
    		Cell[][] grid = new Cell[5][5];
    		
    		for(int i = 0; i < grid.length;i++) {
    			for(int j = 0; j < grid[0].length;j++) {
    				grid[i][j] = new Cell(i,j);
        		}
    		}
    		
   		grid[0][1].energy = 10;
   		grid[1][1].energy = 10;
   		grid[2][1].energy = 10;
   		grid[3][1].energy = 10;
   		
   		grid[1][3].energy = 10;
   		grid[2][3].energy = 10;
   		grid[3][3].energy = 10;
   		grid[4][3].energy = 10;
   
   		AStar search = new AStar(grid,0,0,4,4);
   		//System.out.print(search.grid);
   		search.Search();
   		search.Display();
   		
//   	Grid : 
//		0   10  0   0   0   
//		0   10  0   10  0   
//		0   10  0   10  0   
//		0   10  0   10  0   
//		0   0   0   10  0 
   		
//		Path: (4, 4 , total energy: 0) -> (3, 4 , total energy: 0) 
//   		-> (2, 4 , total energy: 0) -> (1, 4 , total energy: 0) 
//   		-> (0, 4 , total energy: 0) -> (0, 3 , total energy: 0) 
//   		-> (0, 2 , total energy: 0) -> (1, 2 , total energy: 0) 
//   		-> (2, 2 , total energy: 0) -> (3, 2 , total energy: 0) 
//   		-> (4, 2 , total energy: 0) -> (4, 1 , total energy: 0) 
//   		-> (4, 0 , total energy: 0) -> (3, 0 , total energy: 0) 
//   		-> (2, 0 , total energy: 0) -> (1, 0 , total energy: 0) 
//   		-> (0, 0 , total energy: 0)
    }

}
