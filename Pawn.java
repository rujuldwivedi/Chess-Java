public class Pawn extends ChessFigure
{
    // Constructor
    public Pawn(String color, int x, int y)
    {
        super(color, x, y);
    }

    @Override
    // Check if the move is valid
    public boolean isMoveValid(int x1, int y1, int x2, int y2)
    {
        if (y1 == y2) // Check if the move is vertical
        {
            // One forward white
            if (this.getColor().equals("white") && x2 == x1 - 1) 
            return true;

            // Two forward from start white
            if (this.getColor().equals("white") && x2 == x1 - 2 && x1 == 6)
            return true;

            // One forward black
            if (this.getColor().equals("black") && x2 == x1 + 1)
            return true;

            // Two forward from start black
            if (this.getColor().equals("black") && x2 == x1 + 2 && x1 == 1)
            return true;
        }
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
        return "P";
    }

}
