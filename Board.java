
public class Board {

	public boolean[][] createBoard(int n, int l[][]) {
        boolean[][] board = new boolean[n][n];
        for (int m = 0; m < l.length; m++) {
            int x = l[m][0];
            int y = l[m][1];
            board[x][y] = true;
        }
        System.out.println("CurrentGenration");
        String s = printBoard(board);
        System.out.println("NextGenration");
        return board;
    }
	 public String printBoard(boolean board[][]) {
	        StringBuffer sb = new StringBuffer();
	        for (int r = 0; r < board.length; r++) {
	            for (int c = 0; c < board[r].length; c++) {
	                if (board[r][c])
	                    sb.append("*");
	                else
	                    sb.append(".");

	            }
	            sb.append("\n");
	        }
	        return (sb.toString());
	    }

}

