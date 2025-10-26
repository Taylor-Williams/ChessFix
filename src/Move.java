import java.util.List;

import chess.Piece;

public class Move {

    public Move(Piece piece, Position from, Position to) {
        this.piece = piece;
        this.from = from;
        this.to = to;
    }

    public boolean isValid() {
        if (piece.getValidMoves().contains(to)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return (piece.getSymbol() + ": " + from + " -> " + to);
    }
}
