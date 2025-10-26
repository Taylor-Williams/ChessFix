package chess;

import java.util.List;
import java.util.ArrayList;

public class PieceFactory {
    
    public PieceFactory() {

    }

    public Piece createPiece(String type, Color color, Position position) {
        switch (type.toLowerCase()) {
            case "king":
                return createKing(color, position);
            case "queen":
                return createQueenQueen(color, position);
            case "rook":
                return createRookRook(color, position);
            case "bishop":
                return createBishopBishop(color, position);
            case "knight":
                return createKnightKnight(color, position);
            case "pawn":
                return createPawn(color, position);
            default:
                throw new IllegalArgumentException("Unknown piece type: " + type);
        }
    }

    public King createKing(Color color, Position position) {
        return new King(color, position);
    }

    public Queen createQueen(Color color, Position position) {
        return new Queen(color, position);
    }

    public Rook createRook(Color color, Position position) {
        return new Rook(color, position);
    }

    public Bishop createBishop(Color color, Position position) {
        return new Bishop(color, position);
    }

    public Knight createKnight(Color color, Position position) {
        return new Knight(color, position);
    }

    public Pawn createPawn(Color color, Position position) {
        return new Pawn(color, position);
    }
}
