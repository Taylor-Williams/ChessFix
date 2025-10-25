package chess;

import java.util.List;
import java.util.ArrayList;

public abstract class Piece {
    protected Color color;
    protected Position position;
    
    public Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
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
    
    public abstract String getSymbol();
    
    public abstract List<Position> getValidMoves(Board board);
    
    protected List<Position> filterValidMoves(List<Position> potentialMoves, Board board) {
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

