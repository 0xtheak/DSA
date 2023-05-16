package backtracking;

public class NQueen {
	
	public static void placeNQueens(int n) {
		int[][] board = new int[n][n];
		placeQueens(board, 0);
	}
	
	public static void placeQueens(int[][] board, int row){
        if(row==board.length ){
            for(int i = 0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();

            return;
        }
        for(int col=0; col<board.length; col++){
            if(isQueenSafe(board, row, col)==true){
                board[row][col] = 1;
                placeQueens(board, row+1);
                board[row][col] = 0;
            }

        }
    }

    public static boolean isQueenSafe(int[][] board, int row, int col){
        //check vertically
        for(int i=row-1, j=col; i>=0; i--){
            if(board[i][j]==1){
                return false;
            }
        }
        //check left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]==1){
                return false;
            }
        }
        //check right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j]==1){
                return false;
            }

        }

        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		placeNQueens(4);

	}

}
