public class GameBoard
{
    // Attributes
    private static ChessFigure[][] board;

    // Color constants
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m"; // White text
    public static final String ANSI_BLACK = "\u001B[30m"; // Black text
    public static final String ANSI_RED = "\u001B[31m"; // Red text
    public static final String ANSI_BLUE = "\u001B[34m"; // Blue text

    // Constructor
    public GameBoard()
    {
        board = new ChessFigure[8][8];
        initBoard();
        printBoard();
    }

    // Initialize the board
    private void initBoard()
    {
        // Black figures
        board[0][0] = new Rook("black", 0, 0);
        board[0][1] = new Knight("black", 0, 1);
        board[0][2] = new Bishop("black", 0, 2);
        board[0][3] = new Queen("black", 0, 3);
        board[0][4] = new King("black", 0, 4);
        board[0][5] = new Bishop("black", 0, 5);
        board[0][6] = new Knight("black", 0, 6);
        board[0][7] = new Rook("black", 0, 7);

        // Pawns
        for (int i = 0; i < board.length; i++)
        {
            board[1][i] = new Pawn("black", 1, i);
            board[6][i] = new Pawn("white", 6, i);
        }

        // White figures
        board[7][0] = new Rook("white", 7, 0);
        board[7][1] = new Knight("white", 7, 1);
        board[7][2] = new Bishop("white", 7, 2);
        board[7][3] = new Queen("white", 7, 3);
        board[7][4] = new King("white", 7, 4);
        board[7][5] = new Bishop("white", 7, 5);
        board[7][6] = new Knight("white", 7, 6);
        board[7][7] = new Rook("white", 7, 7);
    }

    // Print the board
    public void printBoard()
    {
        // Print the board's notations in the console
        System.out.println("   a  b  c  d  e  f  g  h");

        // Print the board
        for(int i = 0; i < board.length; i++)
        {
            // Print the row number
            System.out.print(8 - i + " ");

            // Print the figures
            for (int j = 0; j < board[i].length; j++)
            {
                // Get the figure
                ChessFigure figure = board[i][j];

                // If there is no figure, print a dash
                if (figure == null)
                System.out.print(" - ");
                
                else
                {
                    // If there is a figure, print the symbol
                    // Use ANSI codes for coloring
                    String color = figure.getColor().equals("white") ? ANSI_WHITE : ANSI_BLACK;
                    String symbol = color + figure.getSymbol() + ANSI_RESET;
                    System.out.print(" " + symbol + " ");
                }
            }

            // Print the row number
            System.out.println(8 - i);
        }

        // Print the board's notations in the console
        System.out.println("   a  b  c  d  e  f  g  h");
    }

    // Get the figure
    public ChessFigure getFigure(int x, int y)
    {
        return board[x][y];
    }

    // Remove the figure
    public void removeFigure(int x, int y)
    {
        board[x][y] = null;
    }

    // Get the board
    public static ChessFigure[][] getBoard()
    {
        return board;
    }
}
