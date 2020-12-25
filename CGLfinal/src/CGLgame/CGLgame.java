package CGLgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CGLgame {
	Board board;
	public CGLgame(String s)throws FileNotFoundException{
		File file=new File(s);
		Scanner sc=new Scanner(file);
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		int[][]l=new int[m][2];
		int i=0;
		 while (sc.hasNextInt()) {
	            l[i][0] = sc.nextInt();
	            l[i++][1] = sc.nextInt();
	        }
		 System.out.println(n);
		 board=new Board(n);
		 board.createBoard(n, l);
		 sc.close();
		
		
	}
	public boolean[][] ReadInput() throws FileNotFoundException{
		return board.getBoard();
	}
	public String printInput() throws FileNotFoundException{
		
		return board.toString();
		}
	public String printOutput() throws FileNotFoundException{
	board.generateNextGeneration();
	
	return board.toString();
	}


}


