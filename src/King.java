package chess;

import java.util.List;
import java.util.ArrayList;

public class King implements Piece {
    
    public King(Color color, Position position) {
        super(color, position);
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
    
    public String getSymbol() {
        return color == Color.WHITE ? "♔" : "♚";
    }
    
    public List<Position> getValidMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        
        // All 8 directions (one square)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        
        for (int[] dir : directions) {
            Position newPos = position.add(dir[0], dir[1]);
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

