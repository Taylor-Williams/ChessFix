package chess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Piece[][] grid;
    private Map<Color, List<Piece>> pieces;
    
    public Board() {
        this.grid = new Piece[8][8];
        this.pieces = new HashMap<>();
        initializeBoard();
    }
    
    private void initializeBoard() {
        // Initialize pawns
        for (int col = 0; col < 8; col++) {
            setPiece(new Pawn(Color.WHITE, new Position(6, col)));
            setPiece(new Pawn(Color.BLACK, new Position(1, col)));
        }
        
        // Initialize rooks
        setPiece(new Rook(Color.WHITE, new Position(7, 0)));
        setPiece(new Rook(Color.WHITE, new Position(7, 7)));
        setPiece(new Rook(Color.BLACK, new Position(0, 0)));
        setPiece(new Rook(Color.BLACK, new Position(0, 7)));
        
        // Initialize knights
        setPiece(new Knight(Color.WHITE, new Position(7, 1)));
        setPiece(new Knight(Color.WHITE, new Position(7, 6)));
        setPiece(new Knight(Color.BLACK, new Position(0, 1)));
        setPiece(new Knight(Color.BLACK, new Position(0, 6)));
        
        // Initialize bishops
        setPiece(new Bishop(Color.WHITE, new Position(7, 2)));
        setPiece(new Bishop(Color.WHITE, new Position(7, 5)));
        setPiece(new Bishop(Color.BLACK, new Position(0, 2)));
        setPiece(new Bishop(Color.BLACK, new Position(0, 5)));
        
        // Initialize queens
        setPiece(new Queen(Color.WHITE, new Position(7, 3)));
        setPiece(new Queen(Color.BLACK, new Position(0, 3)));
        
        // Initialize kings
        setPiece(new King(Color.WHITE, new Position(7, 4)));
        setPiece(new King(Color.BLACK, new Position(0, 4)));
    }
    
    public void setPiece(Piece piece) {
        int row = piece.getPosition().getRow();
        int col = piece.getPosition().getCol();
        grid[row][col] = piece;
    }
    
    public Piece getPiece(Position pos) {
        if (!pos.isValid()) return null;
        return grid[pos.getRow()][pos.getCol()];
    }
    
    public void movePiece(Position from, Position to) {
        Piece piece = getPiece(from);
        if (piece == null) return;
        
        // Remove piece from old position
        grid[from.getRow()][from.getCol()] = null;
        
        // Move piece to new position
        piece.setPosition(to);
        grid[to.getRow()][to.getCol()] = piece;
    }
    
    public void display() {
        System.out.println("\n  a b c d e f g h");
        System.out.println(" ┌─────────────────┐");
        
        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + "│ ");
            for (int col = 0; col < 8; col++) {
                Piece piece = grid[row][col];
                if (piece == null) {
                    // Alternating colors for squares
                    boolean isLight = (row + col) % 2 == 0;
                    System.out.print(isLight ? "·" : " ");
                } else {
                    System.out.print(piece.getSymbol() + " ");
                }
            }
            System.out.println("│");
        }
        
        System.out.println(" └─────────────────┘");
        System.out.println("  a b c d e f g h\n");
    }
}

