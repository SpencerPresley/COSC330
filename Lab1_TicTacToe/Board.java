package Lab1_TicTacToe;
import Lab1_TicTacToe.Player;

public class Board {
    private char [][] board;
    private final int board_size = 3; // board size doesn't change

    // create board, it's a 2D array of chars (row by column)
    public Board()
    {
        this.board = new char[board_size][board_size];
        initializeBoard();
    }

    // used to initialize board with empty cells
    public void initializeBoard()
    {
        for(int i = 0; i < board_size; i++)
        {
            for(int j = 0; j < board_size; j++)
            {
                board[i][j] = ' '; // makes the cell at that ROWxCOLUMN cell as empty
            }
        }
    }

    // method used to print current state of the board
    public void printBoard()
    {
        for(int i = 0; i < board_size; i++)
        {
            for(int j = 0; j < board_size; j++) // prints the | for the correct level
            {
                System.out.print("|" + board[i][j]); // prints the block and then fills in the cell with current value
            }
            System.out.println("|");
            if(i < board_size -1)
            {
                System.out.println("-------"); // once the | for the level have been printed we print the level separator  
            }
        }
    }

    // insert the move to the board
    /*
     * Arguments: row column pair to place symbol at (X or O) as well as which symbol it is
     * Returns: True if it was able to place it there (no other symbol was already there), false otherwise
     */
    public boolean placeMove(int row, int col, char sym) {
        if(row >= 0 && row < board_size && col >= 0 && col < board_size && board[row][col] == ' '){
            board[row][col] = sym;
            return true;
        }
        return false;
    }

    // Check is board is full, returns true if it is, false if it isn't
    public boolean isFull() {
        for(int i = 0; i < board_size; i++)
        {
            for(int j = 0; j < board_size; j++)
            {
                if(board[i][j] == ' ')
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin() {
        // check rows and columns
        for (int i = 0; i < board_size; i++) {
            // Check if it i'th row has the same 3 symbols where board[i][0] can't be empty
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')) {
                return true;
            }

            // Check if i'th column has the same 3 symbols where board[0][i] can't be empty
            if ((board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')) {
                return true;
            }
        }

        // check diagonals
        // top left to bottom right diagonal
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')) {
            return true;
        }

        // top right to bottom left diagonal
        if ((board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
            return true;
        }

        // no win conditions met
        return false;
    }
}
