package CGLgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//* ****************Conways Game Of Life***********************************
// Initially, there is a board with some cells which may be alive or dead. 
//*//Task is to generate the next generation of cells based on the following rules: 
//*     
//* Rule 1: Any live cell with fewer than two live neighbors dies, as if caused by under
//* population. 
//* Rule 2:Any live cell with two or three live neighbors lives on
//* to the next generation. 
//* Rule 3: Any live cell with more than three live  neighbors dies, as if by over population. 
//* Rule 4: Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//* 
//* Step 1 => find the no Of Neighbors that are alive; 
//* Step 2 => apply rules of game to get next generation by use the if conditions
//* to check all neighbors excluding it self as given video lecture
//* 
//* *************Rules of Life********************* 
//* Lonely cell will die ==> aliveNeighbours < 2 ;
//* Cell will die due to over population ==> aliveNeighbours > 3 
//* A new cell will born ==> if currently dead cell have aliveNeighbours == 3
//* 
//* 
//* @author <Danthala Bhagath 20031j0026>
//* @version Version2.3
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


