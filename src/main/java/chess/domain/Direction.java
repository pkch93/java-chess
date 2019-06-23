package chess.domain;

public enum Direction {
    N(0, 1, (x, y) -> x == 0 && y > 0),
    NE(1, 1, (x, y) -> x > 0 && y > 0 && isAbsEqual(x, y)),
    E(1, 0, (x, y) -> x > 0 && y == 0),
    SE(1, -1, (x, y) -> x > 0 && y < 0 && isAbsEqual(x, y)),
    S(0, -1, (x, y) -> x == 0 && y < 0),
    SW(-1, -1, (x, y) -> x < 0 && y < 0 && isAbsEqual(x, y)),
    W(-1, 0, (x, y) -> x < 0 && y == 0),
    NW(-1, 1, (x, y) -> x < 0 && y > 0 && isAbsEqual(x, y)),
    KNIGHT(100, 100, (x, y) -> Math.abs(x) + Math.abs(y) == 3);

    private static boolean isAbsEqual(final int x, final int y) {
        return Math.abs(x) == Math.abs(y);
    }

    private final int x;
    private final int y;
    private final MoveCheck moveCheck;

    Direction(int x, int y, MoveCheck moveCheck) {
        this.x = x;
        this.y = y;
        this.moveCheck = moveCheck;
    }

    public boolean isDiagonal() {
        return this == NE || this == SE || this == SW || this == NW;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Direction valueOf(int x, int y) {
        for (Direction direction : Direction.values()) {
            if (direction.moveCheck.check(x, y)) {
                return direction;
            }
        }
        return KNIGHT;
    }
}
