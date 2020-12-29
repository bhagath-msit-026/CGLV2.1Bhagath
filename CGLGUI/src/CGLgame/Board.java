package CGLgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Board {
	public boolean[][] board;
	public int size1;
	public int size2;
	
	public Board(){
		
	}
	public Board(int size, int size1) {
		this.size1=size1;
		this.size2=size2;
		board = new boolean[size1][size2];
		
	}
	public Board(int size1,int size2,String str ) throws FileNotFoundException {
		this.size1=size1;
		this.size2=size2;
		//if there is no input file it throws filenotfoundexception
		board = new boolean[size1][size2];
		File f = new File(str);
		Scanner sc= new Scanner(f);
		int[][]l=new int[5][2];
		int i=0;
		//scanner function used to scan the input data
		// To read live cells
		 while (sc.hasNextInt()) {
			 String s=sc.nextLine();
			 String[] s1=s.split(" ");
			 l[i][0] = Integer.parseInt(s1[0]);
	         l[i++][1] = Integer.parseInt(s1[1]);
	        }
		 //parsing the data from the console
		 //we are passing size and live cells array
		 createBoard(l);
		 sc.close();
	}
	
	
	
//this method makes the false positions in the board to true based on the input it will create the board
	public void createBoard(int l[][]) {
		for (int i = 0; i < l.length; i++) {
			int row = l[i][0];
			int col = l[i][1];
			board[row][col] = true;
		}

	}
//toString() method is is used to print the board with "*" in place of true and "." in place of false.
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < size1; row++) {
			for (int col = 0; col < size1; col++) {
				if (board[row][col])
					sb.append("*");
				else
					sb.append(".");
			}
			sb.append("\n");
		}
		return sb.toString();

	}
//getter to return board
	public boolean[][] getBoard() {
		return board;
	}
//it will return the board
	
	//Nextgeneration() method is used to create the next generation in board of conways game of life
	//based on the rules of the game next generation will be occured.
	public void Nextgeneration() {
		boolean[][] future = board;
		int j=1;
		while(j<=10) {
		for (int l = 1; l < size1 - 1; l++) {
			for (int m = 1; m < size1 - 1; m++) {
				int aliveNeighbours = 0;
				for (int i = -1; i <= 1; i++)
					for (int j1 = -1; j1 <= 1; j1++)
						if (board[l + i][m + j1])
							aliveNeighbours += 1;
				if (board[l][m])
					aliveNeighbours -= 1;

				if ((board[l][m]) && (aliveNeighbours < 2))
					future[l][m] = false;

				else if ((board[l][m]) && (aliveNeighbours > 3))
					future[l][m] = false;

				else if ((!board[l][m]) && (aliveNeighbours == 3))
					future[l][m] = true;
				else
					future[l][m] = board[l][m];

			}
		}
		future = board;
		
		j++;
		}
	}
}