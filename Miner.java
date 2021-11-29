public class Miner {
	private int rotation; //0deg = right, 90deg = up, and so on
	private int x,y;
                  private String front;
                
	Miner(int sx, int sy) {
		rotation = 0;
		x = sx;
		y = sy;
                                    front = "Right";
	}

	//Rotate counter-clockwise
	public void rotate() {
		rotation = (rotation+90)%360;
                                    
                                    switch(rotation) {
                                        case 0:
			front = "Right"; 
                                                      break;
		   case 90:
			front = "Up";
                                                      break;
		   case 180:
			front = "Left";
                                                      break;
	                     case 270:
			front = "Down";
                                                      break;
                                    }
	}

	//Move forward
	//Note: does not handle collision yet
	public void forward() {
		switch (rotation) {
			case 0:
				++x; break;
			case 90:
				--y; break;
			case 180:
				--x; break;
			case 270:
				++y; break;
			default:
				System.out.println("Miner is facing invalid direction");
				rotation = 0;
				break;
		}
	}
                  
                  // allows the miner to scan mining area on his current front, returns the nearest object in his vicinity
                  public void scan (char[][] grid, String front) {
                      switch(front) {
                            case "Up":
                                    int bClosest = 0;
		for(int i = this.getX(), j = this.getY(); j <= 0; j--){
                                        if(grid[x][y] == 'P' && bClosest == 0){
                                            System.out.print("A pit is nearby");
                                            bClosest = 1;
                                        }
                                        else if(grid[x][y] == 'B' && bClosest == 0){
                                                System.out.print("A beacon is nearby");
                                                bClosest = 1;
                                        }        
                                        else if(grid[x][y] == 'G' && bClosest == 0) {
                                                System.out.print("A pot of is nearby");
                                                 bClosest = 1;
                                        }        
                                    }
                
                                    break;
		  
                           case "Down":
		bClosest = 0;
		for(int i = this.getX(), j = this.getY(); j <= n; j++){
                                        if(grid[x][y] == 'P' && bClosest == 0){
                                            System.out.print("A pit is nearby");
                                            bClosest = 1;
                                        }
                                        else if(grid[x][y] == 'B' && bClosest == 0){
                                                System.out.print("A beacon is nearby");
                                                bClosest = 1;
                                        }        
                                        else if(grid[x][y] == 'G' && bClosest == 0) {
                                                System.out.print("A pot of is nearby");
                                                 bClosest = 1;
                                        }        
                                    }
                
                                    break;
		  
                           case "Left":
		bClosest = 0;
		for(int i = this.getX(), j = this.getY(); i >= 0; i--){
                                        if(grid[x][y] == 'P' && bClosest == 0){
                                            System.out.print("A pit is nearby");
                                            bClosest = 1;
                                        }
                                        else if(grid[x][y] == 'B' && bClosest == 0){
                                                System.out.print("A beacon is nearby");
                                                bClosest = 1;
                                        }        
                                        else if(grid[x][y] == 'G' && bClosest == 0) {
                                                System.out.print("A pot of is nearby");
                                                 bClosest = 1;
                                        }        
                                    }
                
                                    break;
	                  
                           case "Right":
		bClosest = 0;
		for(int i = this.getX(), j = this.getY(); i <= n; i++){
                                        if(grid[x][y] == 'P' && bClosest == 0){
                                            System.out.print("A pit is nearby");
                                            bClosest = 1;
                                        }
                                        else if(grid[x][y] == 'B' && bClosest == 0){
                                                System.out.print("A beacon is nearby");
                                                bClosest = 1;
                                        }        
                                        else if(grid[x][y] == 'G' && bClosest == 0) {
                                                System.out.print("A pot of is nearby");
                                                 bClosest = 1;
                                        }        
                                    }
          
                                    break;
                      }         
                  }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void updateX (int newX) {
		x = newX;
	}

	public void updateY (int newY) {
		y = newY;
	}
}