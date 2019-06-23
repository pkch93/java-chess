package chess.domain.piece;

import chess.domain.AbstractPiece;
import chess.domain.MoveRules;
import chess.domain.Team;

public class Rook extends AbstractPiece {
    private static final String NAME = "r";
    private static final double SCORE = 5;

    public Rook(Team team) {
        super(team, MoveRules::rook);
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
