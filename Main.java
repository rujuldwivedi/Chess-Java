import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Create a new game board
        GameBoard board = new GameBoard();

        Scanner scanner = new Scanner(System.in);

        // Initialize game variables
        boolean whiteTurn = true;
        boolean gameOver = false;
        boolean isDrawOffer = false;
        boolean blackDraw = false;
        boolean whiteDraw = false;

        // Game loop
        while (!gameOver)
        {
            // If it is white's turn, print white turn, else print black turn
            String turnColor = whiteTurn ? "white" : "black";
            System.out.println(turnColor + " turn");

            // Print the move prompt
            System.out.print("Enter move (e2 e4 format, resign, or draw): ");

            // Get the input
            String input = scanner.nextLine().trim();

            // Check for resign command
            if (input.equals("resign"))
            {
                System.out.println(turnColor + " resigns! " + (oppositeColor(turnColor)) + " wins!");
                gameOver = true;
                continue;
            }

            // Check if the input is draw
            if (input.equals("draw"))
            {
                if (turnColor.equals("white"))
                whiteDraw = true;

                else
                blackDraw = true;

                if (whiteDraw && blackDraw)
                {
                    System.out.println("Game ended in a draw!");
                    gameOver = true;
                }

                else
                {
                    System.out.println(turnColor + " offered a draw.");
                    whiteTurn = !whiteTurn;
                    isDrawOffer = true;
                }

                continue;
            }

            // If the above loops are skipped and draw offer stands, this means the draw offer was declined
            if (isDrawOffer)
            {
                System.out.println("Draw offer declined.");
                isDrawOffer = false;
            }

            // Split the input into two moves: from and to. For example, e2 e4
            String[] moves = input.split(" ");

            // Check if the correct number of moves are provided
            if (moves.length != 2)
            {
                System.out.println("Invalid input. Please enter your move in the format: e2 e4");
                continue;
            }

            // Convert input into coordinates (e.g., e2 -> row=6, column=4)
            int x1 = 8 - Character.getNumericValue(moves[0].charAt(1)); // Convert '2' to 6 (array index)
            int y1 = moves[0].charAt(0) - 'a'; // Convert 'e' to 4

            int x2 = 8 - Character.getNumericValue(moves[1].charAt(1)); // Convert '4' to 4 (array index)
            int y2 = moves[1].charAt(0) - 'a'; // Convert 'e' to 4

            // Get the figure at the from coordinates
            ChessFigure figure = board.getFigure(x1, y1);

            // If there is no figure at the from coordinates, print an error message and continue
            if (figure == null)
            {
                board.printBoard();
                System.out.println("No figure at " + moves[0] + ". Try again.");
                continue;
            }

            String oppositeColor = figure.getColor().equals("white") ? "black" : "white";

            // Check if the figure is the same color as the turn, if not print an error message and continue
            if (!figure.getColor().equals(turnColor))
            {
                board.printBoard();
                System.out.println("Wrong figure. Try again.");
                continue;
            }

            // Get the captured figure
            ChessFigure capturedFigure = board.getFigure(x2, y2);

            // Check if the captured figure is a king, if yes, print the winner and end the game
            if (capturedFigure instanceof King && capturedFigure.getColor().equals(oppositeColor))
            {
                gameOver = true;
                System.out.println(turnColor + " wins!");
            }

            // Print the captured figure if it exists
            if (capturedFigure != null)
            System.out.println("Captured " + capturedFigure.getColor() + " " + capturedFigure.getSymbol() + "!");

            // Check if the move is valid
            if (figure.isMoveValid(x1, y1, x2, y2))
            {
                figure.move(x1, y1, x2, y2);
                board.removeFigure(x1, y1);
                board.printBoard();
            }
            else
            {
                // If the move is invalid, print an error message and continue
                board.printBoard();
                System.out.println("Invalid move. Try again.");
                continue;
            }

            // Switch the turn
            whiteTurn = !whiteTurn;
        }

        scanner.close();
    }

    // Helper method to get the opposite color
    private static String oppositeColor(String color)
    {
        return color.equals("white") ? "black" : "white";
    }
}
