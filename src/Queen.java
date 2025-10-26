package chess;

import java.util.List;
import java.util.ArrayList;

public class Queen implements Piece {
    
    public Queen(Color color, Position position) {
        super(color, position);
    }
    
    @Override
    public String getSymbol() {
        return color == Color.WHITE ? "♕" : "♛";
    }
    
    @Override
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
}

