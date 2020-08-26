

public class KnightTour{

	private static int[][] board;
	private static int N;
	private static int[] xMove;
	private static int[] yMove;

	public static void printSol(){
		System.out.println("========================");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void solver(int size){
		N = size;
		board = new int[N][N];
		xMove = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
		yMove = new int[]{1, 2, 2, 1, -1, -2, -2, -1};; 
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				board[i][j] = -1;
		board[0][0] = 0;
		if(solverUtil(0,0,1))
			printSol();
		else
			System.out.println("Solution does not exists");
	}

	public static boolean isSafe(int x, int y){
		return (x>=0 && x<N && y>=0 && y<N && board[x][y] == -1);
	}

	public static boolean solverUtil(int x, int y, int move){
		//printSol();
		if(move == N*N) return true;
		for(int i=0;i<N;i++){
			int nextX = x+xMove[i];
			int nextY = y+yMove[i];
			if(isSafe(nextX,nextY)){
				board[nextX][nextY] = move;
				if(solverUtil(nextX,nextY,move+1)) return true;
				else board[nextX][nextY] = -1;
			}
		}
		return false;
	}

	public static void main(String[] args){
		solver(8);
	}
}
