public class EightQueens {
	public static void main(String[] args) {
		int nQueens = 8;

		// Initialize array
		int[] board = new int[nQueens];
		for (int i = 0; i < board.length; i++) {
			board[i] = -1;
		}

		// Place the first queen to get started
		int currentRow = 0;
		board[currentRow] = 0;
		currentRow++;
		int currentColumn = 0;
		long solutions = 0;
		while (currentRow >= 0) {
			if (isValid(currentRow, currentColumn, board)) {
				board[currentRow] = currentColumn;
				currentRow++;
				currentColumn = 0;

                          	  (currentRow >= board.length) {
					solutions++;
					System.out.println("Solution " + solutions);
					printBoard(board);
					currentRow--;
					currentColumn = board[currentRow] + 1;
				}
			} else {
				// If board is not valid
				currentColumn++;
				if (currentColumn >= board.length) {
					board[currentRow] = -1;
					currentRow--;
					if (currentRow >= 0)
						currentColumn = board[currentRow] + 1;
				}
			}
		}
		System.out.println("Number of solutions for " + nQueens + " queens is " + solutions);
	}

	public static boolean isValid(int currentRow, int currentColumn, int[] board) {
		if (currentColumn >= board.length)
			return false;

		for (int i = 0; i < currentRow; i++) {
			// Check if currentColumn appears in any other currentRow. Then COlumn is
			// occupied.
			if (board[i] == currentColumn)
				return false;

			// Check both diagonals
			if (Math.abs(currentRow - i) == Math.abs(currentColumn - board[i]))
				return false;
		}

		return true;
	}

	public static void printBoard(int[] board) {
		// PrintBoard functionality here
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i] == j)
					System.out.print("|Q");
				else
					System.out.print("| ");
			}
			System.out.println(" |");
		}
	}
}
