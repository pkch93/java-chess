package chess.domain;

import chess.domain.exceptions.IllegalSourceException;
import chess.domain.exceptions.IllegalTargetException;
import chess.domain.piece.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Team turn;
    private final Map<Position, Piece> board;

    private Board() {
        turn = Team.WHITE;
        board = new HashMap<>();
        List<Character> aToH = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');
        List<Piece> piecesTeamBlack = Arrays.asList(
                new Rook(Team.BLACK), new Knight(Team.BLACK), new Bishop(Team.BLACK),
                new Queen(Team.BLACK), new King(Team.BLACK), new Bishop(Team.BLACK),
                new Knight(Team.BLACK), new Rook(Team.BLACK)
        );
        List<Piece> piecesTeamWhite = Arrays.asList(
                new Rook(Team.WHITE), new Knight(Team.WHITE), new Bishop(Team.WHITE),
                new Queen(Team.WHITE), new King(Team.WHITE), new Bishop(Team.WHITE),
                new Knight(Team.WHITE), new Rook(Team.WHITE)
        );

        for (int i = 0; i < aToH.size(); i++) {
            board.put(new Position(new Coordinate(aToH.get(i)), new Coordinate(8)), piecesTeamBlack.get(i));
            board.put(new Position(new Coordinate(aToH.get(i)), new Coordinate(1)), piecesTeamWhite.get(i));
        }

        aToH.forEach(character -> board.put(new Position(new Coordinate(character), new Coordinate(7)), new Pawn(Team.BLACK)));
        aToH.forEach(character -> board.put(new Position(new Coordinate(character), new Coordinate(2)), new Pawn(Team.WHITE)));
    }


    public static Board init() {
        return new Board();
    }

    public Piece at(final Position position) {
        return board.get(position);
    }

    public String boardAt(final Position position) {
        if (!board.containsKey(position)) {
            return ".";
        }

        Piece piece = board.get(position);

        if (piece.isBlackTeam()) {
            return piece.getName();
        }
        return piece.getName().toUpperCase();
    }

    public void move(Position source, Position target) {
        if (!board.containsKey(source)) {
            throw new IllegalSourceException("해당 위치에 말이 없습니다.");
        }

        Piece sourcePiece = board.get(source);
        if (!sourcePiece.isSameTeam(turn)) {
            throw new IllegalSourceException("당신의 턴이 아닙니다. 기다리세요.");
        }

        if (board.containsKey(target) && sourcePiece.isSameTeam(board.get(target))) {
            throw new IllegalTargetException("같은 팀이 있는 위치로 이동이 불가능합니다.");
        }

        Direction direction = source.direction(target);
        if (!validRoute(source, target, direction)) {
            throw new IllegalTargetException("경로에 말이 존재합니다."); // todo: Exception 이름 변경
        }

        sourcePiece.canMove(source, target);
        board.remove(source);
        // todo: 상대방 말이 있는데 상대방 말이 무엇인지
        board.put(target, sourcePiece);
        turn = turn.turnChanged();
    }

    private boolean validRoute(final Position source, final Position target, final Direction direction) {
        if (direction == Direction.OTHER) {
            return true;
        }

        for (Position checking = source.add(direction); !checking.equals(target); checking = checking.add(direction)) {
            if (this.at(checking) != null) {
                return false;
            }
        }

        return true;
    }
}
