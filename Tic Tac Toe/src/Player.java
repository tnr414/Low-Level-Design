package src;

public class Player {
    private final int id;
    private final String name;
    private Piece piece;

    public Player(String name, Piece piece, int id) {
        this.name = name;
        this.piece = piece;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
