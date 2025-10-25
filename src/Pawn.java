package chess;

import java.util.List;
import java.util.ArrayList;

public class Pawn extends Piece {
    
    public Pawn(Color color, Position position) {
        super(color, position);
    }
    
    @Override
    public String getSymbol() {
        return color == Color.WHITE ? "♙" : "♟";
    }
    
    @Override
    public List<Position> getValidMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        int direction = color == Color.WHITE ? -1 : 1;
        
        // Forward move
        Position forward = position.add(direction, 0);
        if (forward.isValid() && board.getPiece(forward) == null) {
            moves.add(forward);
            
            // Double move from starting position
            if ((color == Color.WHITE && position.getRow() == 6) || 
                (color == Color.BLACK && position.getRow() == 1)) {
                Position doubleForward = position.add(direction * 2, 0);
                if (doubleForward.isValid() && board.getPiece(doubleForward) == null) {
                    moves.add(doubleForward);
                }
            }
        }
        
        // Diagonal captures
        Position leftDiag = position.add(direction, -1);
        if (leftDiag.isValid()) {
            Piece target = board.getPiece(leftDiag);
            if (target != null && target.getColor() != this.color) {
                moves.add(leftDiag);
            }
        }
        
        Position rightDiag = position.add(direction, 1);
        if (rightDiag.isValid()) {
            Piece target = board.getPiece(rightDiag);
            if (target != null && target.getColor() != this.color) {
                moves.add(rightDiag);
            }
        }
        
        return moves;
    }
}

