package com.game.chess.pieces.pawn.rules;

import com.game.chess.board.tiles.Position;
import com.game.chess.pieces.Rule;

public class OneStepForwardRule implements Rule {
    @Override
    public boolean apply(Position currentPosition, Position destinationPosition) {
        int ySteps = destinationPosition.subtractYCoordinate(currentPosition);
        int xSteps = destinationPosition.subtractXCoordinate(currentPosition);

        if(!destinationPosition.isOccupied()) {
            if (xSteps == 0 && ySteps == 1) {
                return true;
            }
        }

        return false;

    }
}
