package ToeTacTic;
import ToeTacTic.Board;
import ToeTacTic.Player;
import java.util.Scanner;

public class Game {
    // private variables
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    
    public Game() {
        board = new Board();
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        currentPlayer = player1; // player 1 goes first
    }

    // Starts the game
    public void start() {
        Scanner scanner = new Scanner(System.in);

        // main game loop
        while (true) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSym() +")'s turn:");
            System.out.print("Enter row and column numbers (1-3; middle position would be 2 2) separated by a space: ");
            
            // get users inputs, subtract the integer to match the 0 indexing of the 2D board array
            int row = (scanner.nextInt() - 1);
            int col = (scanner.nextInt() - 1);
            
            // if state of game allows for placing of the symbol into the position we do that
            if (board.placeMove(row, col, currentPlayer.getSym())) {
                
                // once move is placed check to see if the player met a win condition
                if (board.checkWin()) {
                    board.printBoard();
                    System.out.println(currentPlayer.getName() + " won!");
                    break;
                }

                // if they didn't meet a win condition check if the board is full as that would indicate a tie
                else if (board.isFull()) {
                    board.printBoard();
                    System.out.println("It's a tie!");
                    break;
                }

                // if the player didn't win and the board isn't full we switch players
                else {
                    // Switch players
                    if (currentPlayer == player1) {
                        currentPlayer = player2;
                    } 
                    
                    else {
                        currentPlayer = player1;
                    }
                }
            }

            // else we notify the player that their move isn't valid and to go again
            else {
                System.out.println("Invalid move! Try again.");
            }
        }

        // close the scanner once the game concludes
        scanner.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}