package com.game.chess.pieces.pawn.rules;

import com.game.chess.board.tiles.Position;
import com.game.chess.pieces.Rule;

public class TwoStepForwardRule implements Rule {

    private boolean alreadyMoved;

    public TwoStepForwardRule(boolean alreadyMoved) {
        this.alreadyMoved = alreadyMoved;
    }

    @Override
    public boolean apply(Position currentPosition, Position destinationPosition) {
        if (alreadyMoved || destinationPosition.isOccupied()) {
            return false;
        } else {

            int ySteps = destinationPosition.subtractYCoordinate(currentPosition);
            int xSteps = destinationPosition.subtractXCoordinate(currentPosition);

            if (xSteps == 0 && ySteps == 2) {
                return true;
            }

            return false;
        }
    }
}
