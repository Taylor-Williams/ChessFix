package chess;

import java.util.List;
import java.util.ArrayList;

public interface Piece {
    
    public Color getColor() ;
    
    public Position getPosition() ;
    
    public void setPosition(Position position) ;
    
    public abstract String getSymbol();
    
    public abstract List<Position> getValidMoves(Board board);
    
    public List<Position> filterValidMoves(List<Position> potentialMoves, Board board);
}

