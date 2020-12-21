public class Sudoku{
	
	static boolean isSafe(int[][] grid, int row,int col, int x){
		//check row & col wise
		for(int i=0;i<9;i++){
			if(grid[row][i]==x || grid[i][col]==x)
				return false;
		}
		
		//check in square
		int start = 0;
		int end = 0;
		if(row>=0 && row <=2) start = 0;
		if(row>=3 && row <=5) start = 3;
		if(row>=6 && row <=8) start = 6;
		
		if(col>=0 && col <=2) end = 0;
		if(col>=3 && col <=5) end = 3;
		if(col>=6 && col <=8) end = 6;
		
		for(int i=start;i<start+3;i++){
			for(int j=end;j<end+3;j++){
				if(grid[i][j] == x)
					return false;
			}
		}
		return true;
	}
	
	static boolean sudokuUtil(int[][] grid, int row, int col){
		if(row==9) return true;
		if(col==9) return sudokuUtil(grid,row+1,0);
		
		if(grid[row][col]!=0){
			return sudokuUtil(grid,row,col+1);
		}
		
		for(int i=1;i<=9;i++){
			if(isSafe(grid,row,col,i)){
				grid[row][col] = i;
				if(sudokuUtil(grid,row,col+1))
					return true;
			}
		}
		grid[row][col] = 0;
		return false;
	}
	
	static boolean SolveSudoku(int grid[][])
    {
        return sudokuUtil(grid, 0,0);
    }
    
    static void printGrid (int grid[][])
    {
        for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
    }

	public static void main(String[] args){
		int grid[][] = 
						{{3,0,6,5,0,8,4,0,0},
						{5,2,0,0,0,0,0,0,0},
						{0,8,7,0,0,0,0,3,1,},
						{0,0,3,0,1,0,0,8,0},
						{9,0,0,8,6,3,0,0,5},
						{0,5,0,0,9,0,6,0,0},
						{1,3,0,0,0,0,2,5,0},
						{0, 0,0,0,0,0,0,7,4},
						{0,0,5,2,0,6,3,0,0}};
		SolveSudoku(grid);	
		printGrid (grid);
	}
}