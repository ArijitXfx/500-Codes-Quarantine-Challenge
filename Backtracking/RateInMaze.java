import java.util.*;

public class RateInMaze{
	
	private static ArrayList<String> result = new ArrayList<String>();
	
	public static boolean isSafe(int[][] maze, int N, int x, int y){
		return x>=0 && y>=0 && x<N && y<N && maze[x][y] == 1;
	}
	
	public static void solverUtil(int[][] maze, int N, int x, int y, char move, String curr){
		if(x==N-1 && y==N-1 && maze[x][y]==1){
			curr += move;
			result.add(curr.substring(1));
			curr = "";
			return;
		}
		
		if(isSafe(maze,N,x,y)){
			curr += move;
			solverUtil(maze,N,x+1,y,'D',curr);
			solverUtil(maze,N,x,y+1,'R',curr);
		}
	}
	
	public static void solver(int[][] maze, int N){
		solverUtil(maze, N, 0, 0, '$', "");
	}
	
	public static void main(String[] args){
		int[][] maze = {{1, 0, 0, 0},
                       {1, 1, 0, 1}, 
                       {1, 1, 0, 0},
                       {0, 1, 1, 1}};
		int N = 4;
		solver(maze,4);
		System.out.println(result);
	}
}