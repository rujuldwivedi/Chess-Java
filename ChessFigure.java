public abstract class ChessFigure implements FigureMove
{

    // ANSI color codes for terminal output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m"; // White text
    public static final String ANSI_BLACK = "\u001B[30m"; // Black text
    public static final String ANSI_BLUE = "\u001B[34m"; // Blue text
    public static final String ANSI_RED = "\u001B[31m"; // Red text

    // Attributes
    private String color;
    private int x; // x-coordinate (row)
    private int y; // y-coordinate (column)

    // Board
    protected ChessFigure[][] board = GameBoard.getBoard(); // Made protected if needed in subclasses

    // Constructor
    ChessFigure(String color, int x, int y)
    {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    // Getters
    public String getColor()
    {
        return color;
    }

    public int getX()
    {
        return x; // Getter for x-coordinate
    }

    public int getY()
    {
        return y; // Getter for y-coordinate
    }

    // Get the color representation for the piece
    public String getColorRepresentation()
    {
        return getColor().equals("white") ? ANSI_WHITE : ANSI_BLACK;
    }

    // Abstract method to get the symbol representation of the piece
    public abstract String getSymbol();

    // Move the piece to new coordinates
    public void move(int newX, int newY)
    {
        this.x = newX;
        this.y = newY;
    }

    // Abstract method to check if a move is valid
    public abstract boolean isMoveValid(int fromX, int fromY, int toX, int toY);
}
