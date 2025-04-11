public class PracticeProblem {

	public static void main(String args[]) {}

	public static int searchMazeMoves(String[][] arr) {

		int row = arr.length-1;
		int col = 0;

		int noOfMoves = 0;

		int MVOES = searchMazeMovesHelper(arr, row, col, noOfMoves);

		if (MVOES == 10000000) {
			return -1;
		}

		return MVOES;
	}

	public static int searchMazeMovesHelper(String[][] arr, int row, int col, int moves) {

		if (row < 0 || col > arr[row].length-1) {	
			return 10000000;
		}

		if (arr[row][col].equals("*")) {
			return 10000000;
		}

		if (arr[row][col].equals("F")) {
			return moves;
		}

		return Math.min(searchMazeMovesHelper(arr, row-1, col, moves+1), searchMazeMovesHelper(arr, row, col+1, moves+1));
		//return searchMazeMovesHelper(arr, row-1, col, moves+1);
		//return searchMazeMovesHelper(arr, row, col+1, moves+1);
	}

	public static int noOfPaths(String[][] arr) {

		int row = arr.length-1;
		int col = 0;

		int noOfPaths = 0;

		return noOfPathsHelper(arr, row, col, noOfPaths);
	}

	public static int noOfPathsHelper(String[][] arr, int row, int col, int path) {

		if (row < 0 || col > arr[row].length-1) {	
			return 0;
		}

		if (arr[row][col].equals("*")) {	
			return 0;
		}

		if (arr[row][col].equals("F")) {
			return path = path+1;
		}

		return noOfPathsHelper(arr, row-1, col, path) + noOfPathsHelper(arr, row, col+1, path);
	}
}