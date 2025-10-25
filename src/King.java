package chess;

import java.util.List;
import java.util.ArrayList;

public class King extends Piece {
    
    public King(Color color, Position position) {
        super(color, position);
    }
    
    @Override
    public String getSymbol() {
        return color == Color.WHITE ? "♔" : "♚";
    }
    
    @Override
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
}

