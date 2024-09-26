public class Bishop extends ChessFigure
{
    // Constructor
    public Bishop(String color, int x, int y)
    {
        super(color, x, y);
    }

    @Override
    // Check if the move is valid
    public boolean isMoveValid(int x1, int y1, int x2, int y2)
    {
        // Check if the move is within the board
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        // Check if the move is diagonal
        if (dx != dy)
        return false;

        // Check if there is no other figure on the way
        int xDir = (x2 - x1) / Math.abs(x2 - x1);
        int yDir = (y2 - y1) / Math.abs(y2 - y1);

        int x = x1 + xDir;
        int y = y1 + yDir;

        // This loop checks if there are any figures on the way
        while (x != x2 && y != y2)
        {
            if (board[x][y] != null) 
            return false;

            x += xDir;
            y += yDir;
        }
        return true;
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
        return "B";
    }
}
