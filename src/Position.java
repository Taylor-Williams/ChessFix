package chess;

public class Position {
    private int row;
    private int col;
    
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public boolean isValid() {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
    
    public Position add(int rowOffset, int colOffset) {
        return new Position(this.row + rowOffset, this.col + colOffset);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return row == position.row && col == position.col;
    }
    
    @Override
    public String toString() {
        char colChar = (char)('a' + col);
        return String.valueOf(colChar) + (row + 1);
    }
    
    public static Position fromString(String pos) {
        if (pos.length() != 2) return null;
        int col = pos.charAt(0) - 'a';
        int row = pos.charAt(1) - '1';
        Position p = new Position(row, col);
        return p.isValid() ? p : null;
    }
}

