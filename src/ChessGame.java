package chess;

import java.util.List;
import java.util.Scanner;

public class ChessGame {
    public Board board;
    private Color currentPlayer;
    private Scanner scanner;
    
    public ChessGame() {
        this.board = new Board();
        this.currentPlayer = Color.WHITE;
        this.scanner = new Scanner(System.in);
    }
    
    public void play() {
        System.out.println("Welcome to ChessFix!");
        System.out.println("Enter moves in the format: from_position to_position (e.g., e2 e4)");
        System.out.println("Type 'quit' to exit the game.\n");
        
        while (true) {
            board.display();
            System.out.println("Current player: " + currentPlayer);
            System.out.print("Enter move: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }
            
            String[] parts = input.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid format. Please use: e2 e4");
                continue;
            }
            
            Position from = Position.fromString(parts[0]);
            Position to = Position.fromString(parts[1]);
            
            if (from == null || to == null) {
                System.out.println("Invalid position. Use format like 'e2' or 'e4'.");
                continue;
            }
            
            if (makeMove(from, to)) {
                currentPlayer = currentPlayer.opposite();
            }
        }
        
        scanner.close();
    }
    
}

