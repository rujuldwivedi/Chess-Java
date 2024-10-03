public abstract class ChessFigure implements FigureMove
{
    // ANSI color codes for terminal output
    public static final String ANSI_RESET = "\u001B[0m"; 
    public static final String ANSI_WHITE = "\u001B[37m"; // White text
    public static final String ANSI_BLACK = "\u001B[30m"; // Black text
    public static final String ANSI_BLUE = "\u001B[34m"; // Blue text
    public static final String ANSI_RED = "\u001B[31m"; // Red text

    // Attributes
    protected String color; // Made protected to allow subclasses direct access
    protected int x; // x-coordinate (row)
    protected int y; // y-coordinate (column)
    protected boolean hasMoved; // Track if the piece has moved

    // Board
    protected ChessFigure[][] board = GameBoard.getBoard(); // Made protected if needed in subclasses

    // Constructor (changed to protected for better encapsulation)
    protected ChessFigure(String color, int x, int y)
    {
        this.color = color;
        this.x = x;
        this.y = y;
        this.hasMoved = false; // Initialize to false when the piece is created
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
        if ("white".equalsIgnoreCase(color))
        return ANSI_WHITE;
        
        else if ("black".equalsIgnoreCase(color))
        return ANSI_BLACK;

        return ANSI_RESET; // Return default if color is invalid
    }

    // Abstract method to get the symbol representation of the piece
    public abstract String getSymbol();

    // Move the piece to new coordinates
    public void move(int newX, int newY)
    {
        // Optional: Update the board to reflect the move
        board[x][y] = null; // Remove piece from current position
        board[newX][newY] = this; // Place piece at new position

        // Update the piece's coordinates
        this.x = newX;
        this.y = newY;

        // Mark the piece as having moved
        this.hasMoved = true; 
    }

    // Check if the piece has moved
    @Override
    public boolean hasMoved() 
    {
        return this.hasMoved; 
    }

    // Abstract method to check if a move is valid
    public abstract boolean isMoveValid(int fromX, int fromY, int toX, int toY);
}
