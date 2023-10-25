class Main {
	public static void main(String[] args) {
		char[][] board = new char[9][];
		board[0] = new char[] {'5','3','.','.','7','.','.','.','.'};
		board[1] = new char[] {'6','.','4','1','9','5','.','.','.'};
		board[2] = new char[] {'.','9','8','.','.','.','.','6','.'};
		board[3] = new char[] {'8','.','.','.','6','.','.','.','3'};
		board[4] = new char[] {'4','.','.','8','.','3','.','.','1'};
		board[5] = new char[] {'7','.','.','.','2','.','.','.','6'};
		board[6] = new char[] {'.','6','.','.','.','.','2','8','.'};
		board[7] = new char[] {'.','.','.','4','1','9','.','.','5'};
		board[8] = new char[] {'.','.','.','.','8','.','.','7','9'};
		Solution solution = new Solution();
		boolean result = solution.isValidSudoku(board);
		System.out.println(result);
	}
}

class Solution {
	public boolean isValidSudoku(char[][] board)  {
		int[] frequency = new int[9];
		
		int[][][] squares = new int[3][3][9];
		for (int i = 0; i < 9; i++) {
			frequency = new int[9];
			for (int j = 0; j < 9; j++) {
				if (isSudokuDigit(board[i][j])) {
					frequency[board[i][j] - '1']++;
					squares[i / 3][j / 3][board[i][j] - '1']++;
					if (frequency[board[i][j] - '1'] > 1 || squares[i / 3][j / 3][board[i][j] - '1'] > 1) return false;
				}
			}
		}
		for (int j = 0; j < 9; j++) {
			frequency = new int[9];
                        for (int i = 0; i < 9; i++) {
                                if (isSudokuDigit(board[i][j])) {
                                        frequency[board[i][j] - '1']++;
                                        if (frequency[board[i][j] - '1'] > 1) return false;
                                }
                        }
                }

		return true;
	}

		public boolean isSudokuDigit(char ch) {
			return (ch >= '1' && ch <= '9');
		}

	}
