package chess;

import java.util.List;
import java.util.ArrayList;

public class Knight extends Piece {
    
    public Knight(Color color, Position position) {
        super(color, position);
    }
    

    public String getSymbol() {
        return color == Color.WHITE ? "♘" : "♞";
    }
    
    
    public Color getColor() {
        return color;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Position> getValidMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        
        // Knight's L-shaped moves
        int[][] knightMoves = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };
        
        for (int[] move : knightMoves) {
            Position newPos = position.add(move[0], move[1]);
            if (newPos.isValid()) {
                Piece target = board.getPiece(newPos);
                if (target == null || target.getColor() != this.color) {
                    moves.add(newPos);
                }
            }
        }
        
        return moves;
    }

    public List<Position> filterValidMoves(List<Position> potentialMoves, Board board) {
        List<Position> validMoves = new ArrayList<>();
        for (Position move : potentialMoves) {
            if (move.isValid()) {
                Piece targetPiece = board.getPiece(move);
                if (targetPiece == null || targetPiece.getColor() != this.color) {
                    validMoves.add(move);
                }
            }
        }
        return validMoves;
    }
}

