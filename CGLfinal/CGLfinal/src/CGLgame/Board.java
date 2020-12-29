package CGLgame;

public class Board {
	private boolean[][] board;
	private int size;
	
	public Board(int n) {
		size=n;
		board = new boolean[n][n];
	}
	
	public void createBoard(int n, int l[][]) {
		int row, col;
		for(int i=0;i<l.length;i++) {
			row = l[i][0];
			col = l[i][1];
			board[row][col] = true;
		}
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int row=0;row<size; row++) {
			for(int col=0;col<size; col++) {
				if (board[row][col]) {
					sb.append("*");
				}
				else {
					sb.append(".");
				}
			}
		sb.append("\n");
		}
	return sb.toString();
	}
	public boolean[][] getBoard(){
		return board;
	}
	public int getsize() {
		return size;
	}
	public void generateNextGeneration() {
		boolean[][] future = board;
		//loop through every cell
		for (int l=1; l<size-1; l++) {
			for(int m=1; m<size-1;m++) {
				//finding no of Neighbors that are alive
				int aliveNeighbours=0;
				for(int i=-1;i<=1;i++)
					for(int j=-1; j<=1; j++)
						if(board[l+i][m+j])
							aliveNeighbours +=1;
				// the cell needs to be subtracted from
				//its neighbors as it was counted before
				if(board[l][m])
					aliveNeighbours -=1;
				// Implementing the Rule of Life
			
				// cell is lonely and dies
				if ((board[l][m]) && (aliveNeighbours<2))
					future [l][m]=false;
				//cell dies due to over population
				else if((board[l][m])&&(aliveNeighbours>3))
					future[l][m]=true;
	             // A new cell is born
				else if ((!board[l][m]) && (aliveNeighbours ==3))
					future[l][m]=true;
				else
					future[l][m]= board[l][m];
				}
			}
			board = future;
		}


}
