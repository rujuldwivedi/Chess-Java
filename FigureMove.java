public interface FigureMove
{
    // Check if the move is valid
    boolean isMoveValid(int x1, int y1, int x2, int y2);

    // Move the figure
    void move(int x1, int y1, int x2, int y2);

    // Check if the figure has moved
    boolean hasMoved();
}
