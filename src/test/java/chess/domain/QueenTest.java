package chess.domain;

import chess.domain.piece.Queen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    Piece piece;
    Position base;

    @BeforeEach
    void setUp() {
        piece = new Queen(Team.BLACK);
        base = new Position(new Coordinate('d'), new Coordinate(4));
    }

    @Test
    void 상하_이동_여부_테스트() {
        assertTrue(piece.canMove(base, new Position(new Coordinate('d'), new Coordinate(1))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('d'), new Coordinate(2))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('d'), new Coordinate(3))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('d'), new Coordinate(5))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('d'), new Coordinate(6))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('d'), new Coordinate(7))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('d'), new Coordinate(8))));
    }

    @Test
    void 좌우_이동_여부_테스트() {
        assertTrue(piece.canMove(base, new Position(new Coordinate('a'), new Coordinate(4))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('b'), new Coordinate(4))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('c'), new Coordinate(4))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('e'), new Coordinate(4))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('f'), new Coordinate(4))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('g'), new Coordinate(4))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('h'), new Coordinate(4))));
    }

    @Test
    void 우상향_대각선_이동_여부_테스트() {
        assertTrue(piece.canMove(base, new Position(new Coordinate('a'), new Coordinate(1))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('b'), new Coordinate(2))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('c'), new Coordinate(3))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('e'), new Coordinate(5))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('f'), new Coordinate(6))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('g'), new Coordinate(7))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('h'), new Coordinate(8))));
    }

    @Test
    void 좌상향_대각선_이동_여부_테스트() {
        assertTrue(piece.canMove(base, new Position(new Coordinate('a'), new Coordinate(7))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('b'), new Coordinate(6))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('c'), new Coordinate(5))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('e'), new Coordinate(3))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('f'), new Coordinate(2))));
        assertTrue(piece.canMove(base, new Position(new Coordinate('g'), new Coordinate(1))));
    }
}