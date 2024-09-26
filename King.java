public class King extends ChessFigure
{
    // Constructor
    public King(String color, int x, int y)
    {
        super(color, x, y);
    }


    @Override
    // Check if the move is valid
    public boolean isMoveValid(int x1, int y1, int x2, int y2)
    {
        // Check if the move is within the board
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);

        if (dx <= 1 && dy <= 1)
        return true;

        return false;
    }

    @Override
    // Move the figure
    public void move(int x1, int y1, int x2, int y2)
    {
        ChessFigure piece = board[x1][y1];
        board[x2][y2] = piece;
    }

    @Override
    // Get the symbol of the figure
    public String getSymbol()
    {
        return "K";
    }
}
