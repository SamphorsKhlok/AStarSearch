
public class Cell {
    int totalEngery = 0;
	int energy = 0;
	
    int i, j;
    Cell parent; 
    
    Cell(int i, int j){
        this.i = i;
        this.j = j; 
    }
    
    @Override
    public String toString(){
        return "("+this.i+", "+this.j+ " , total energy: "+ this.totalEngery +")";
    }
}