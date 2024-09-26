import java.util.Scanner;

public class Game
{
    // Attributes
    Scanner scanner = new Scanner(System.in);

    // Constructor
    public Game()
    {
        new GameBoard();
        System.out.println("Choose your move: ");
        scanner.nextLine();
    }
}
