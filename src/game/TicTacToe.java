package game;

public class TicTacToe {
    private char[][] board;
    private char currentChar;
    private boolean isPlayerOne;
    
    private static final char BOARD_SIZE = 3;
    private static final char PLAYER_ONE = 'x';
    private static final char PLAYER_TWO = 'o';

    public TicTacToe() {
        this.board = new char[BOARD_SIZE][BOARD_SIZE];
        this.isPlayerOne = true;
        this.populateBoard();
    }

    public boolean play(int line, int column) throws CellFiledException {
        if(board[line][column] != ' ') {
            throw new CellFiledException();
        }
        if(line < 0 || line > 2 || column < 0 || column > 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
         
        this.currentChar = isPlayerOne ? PLAYER_ONE : PLAYER_TWO;
        board[line][column] = currentChar;
        isPlayerOne = !isPlayerOne;

        return line(line) || column(column) || crossLeftToRight(line, column) || crossRightToLeft(line, column);
    }

    private boolean line(int lineIndex) {
        char[] line = board[lineIndex];
        for(char c : line) {
            if(currentChar != c) {
                return false;
            }
        }
        return true;
    }

    private boolean column(int column) {
        for(int i = 0; i < BOARD_SIZE; i++) {
            if (currentChar != board[i][column]) {
                return false;
            }
        }

        return true;
    }

    private boolean crossLeftToRight(int line, int column) {
        if(line == column) {
            for(int i = 0; i < BOARD_SIZE; i++) {
                if(board[i][i] != currentChar) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    private boolean crossRightToLeft(int line, int column) {
        if(line + column == 2) {
            for(int i = 0, j = 2; i < BOARD_SIZE; i++, j--) {
                if(board[i][j] != currentChar) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }


    private void populateBoard() {
        for(char[] line : this.board) {
            for(int i = 0; i < line.length; i++) {
                line[i] = ' ';
            }
        }
    }
}
