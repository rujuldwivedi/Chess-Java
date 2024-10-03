public class King extends ChessFigure
{
    private boolean hasMoved = false;

    // Constructor
    public King(String color, int x, int y)
    {
        super(color, x, y);
    }

    @Override
    // Check if the move is valid (including castling logic)
    public boolean isMoveValid(int x1, int y1, int x2, int y2)
    {
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);

        // Normal king move (one square in any direction)
        if (dx <= 1 && dy <= 1) {
            return true;
        }

        // Castling conditions (either kingside or queenside)
        if (!hasMoved && dx == 0 && (dy == 2 || dy == -2)) {
            // Kingside castling (e1 g1 or e8 g8)
            if (y2 == 6 && board[x1][7] instanceof Rook) {
                Rook rook = (Rook) board[x1][7];
                if (!rook.hasMoved() && isPathClear(x1, y1, y2)) {
                    return true;
                }
            }
            // Queenside castling (e1 c1 or e8 c8)
            else if (y2 == 2 && board[x1][0] instanceof Rook) {
                Rook rook = (Rook) board[x1][0];
                if (!rook.hasMoved() && isPathClear(x1, y1, y2)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Check if the path is clear between the king and the rook
    private boolean isPathClear(int row, int col1, int col2)
    {
        int start = Math.min(col1, col2) + 1;
        int end = Math.max(col1, col2) - 1;

        for (int col = start; col <= end; col++) {
            if (board[row][col] != null) {
                return false;
            }
        }

        return true;
    }

    @Override
    // Move the figure (including castling)
    public void move(int x1, int y1, int x2, int y2)
    {
        // Castling: move rook along with the king
        if (!hasMoved && y2 == 6 && board[x1][7] instanceof Rook) { // Kingside
            Rook rook = (Rook) board[x1][7];
            rook.move(x1, 7, x1, 5); // Move rook to f1 or f8
        } else if (!hasMoved && y2 == 2 && board[x1][0] instanceof Rook) { // Queenside
            Rook rook = (Rook) board[x1][0];
            rook.move(x1, 0, x1, 3); // Move rook to d1 or d8
        }

        // Move king
        board[x2][y2] = this;
        board[x1][y1] = null;
        this.x = x2;
        this.y = y2;
        this.hasMoved = true; // Mark king as having moved
    }

    @Override
    // Get the symbol of the figure
    public String getSymbol()
    {
        return "K";
    }

    public boolean hasMoved()
    {
        return hasMoved;
    }
}
