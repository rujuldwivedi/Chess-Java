public class Rook extends ChessFigure
{
    private boolean hasMoved = false;

    // Constructor
    public Rook(String color, int x, int y)
    {
        super(color, x, y);
    }

    @Override
    // Check if the move is valid
    public boolean isMoveValid(int x1, int y1, int x2, int y2)
    {
        // Check if the move is vertical or horizontal
        if (!(x1 == x2 || y1 == y2)) return false;

        // Initialize the direction of the move
        int dx = 0, dy = 0;
        if (x1 != x2) dx = Integer.compare(x2, x1);
        if (y1 != y2) dy = Integer.compare(y2, y1);

        // Check if the path is clear
        int currX = x1 + dx, currY = y1 + dy;
        while (currX != x2 || currY != y2) {
            if (board[currX][currY] != null) return false;
            currX += dx;
            currY += dy;
        }

        return true;
    }

    @Override
    // Move the figure
    public void move(int x1, int y1, int x2, int y2)
    {
        board[x2][y2] = this;
        board[x1][y1] = null;
        this.x = x2;
        this.y = y2;
        this.hasMoved = true; // Mark rook as having moved
    }

    @Override
    // Get the symbol of the figure
    public String getSymbol()
    {
        return "R";
    }

    public boolean hasMoved()
    {
        return hasMoved;
    }
}
