package chess.domain.piece;

import chess.domain.MoveRules;
import chess.domain.Piece;
import chess.domain.Team;

public class Knight extends Piece {
    public static final double SCORE = 2.5;
    private static final String NAME = "n";

    public Knight(Team team) {
        super(team, MoveRules::knight);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double getScore() {
        return SCORE;
    }
}
