package chess;

import java.util.List;
import java.util.ArrayList;

public class Queen implements Piece {
    
    public Queen(Color color, Position position) {
        super(color, position);
    }
    
    public String getSymbol() {
        return color == Color.WHITE ? "♕" : "♛";
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
        
        // All 8 directions (rook + bishop moves)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        
        for (int[] dir : directions) {
            for (int i = 1; i < 8; i++) {
                Position newPos = position.add(dir[0] * i, dir[1] * i);
                if (!newPos.isValid()) break;
                
                Piece target = board.getPiece(newPos);
                if (target == null) {
                    moves.add(newPos);
                } else {
                    if (target.getColor() != this.color) {
                        moves.add(newPos);
                    }
                    break;
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

