public class Queen extends ChessFigure
{
    // Constructor
    public Queen(String color, int x, int y)
    {
        super(color, x, y);
    }

    @Override
    // Check if the move is valid
    public boolean isMoveValid(int x1, int y1, int x2, int y2)
    {
        //bishop check
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        if (dx == dy)
        return true;

        //rook check
        if (x1 == x2 || y1 == y2)
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
        return "Q";
    }
}
