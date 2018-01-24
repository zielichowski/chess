package com.game.chess.pieces.pawn.rules;

import com.game.chess.board.tiles.Position;
import com.game.chess.pieces.Rule;

public class AttackRule implements Rule {

    @Override
    public boolean apply(Position currentPosition, Position destinationPosition) {
        if (destinationPosition.isOccupied()) {

            int ySteps = destinationPosition.subtractYCoordinate(currentPosition);
            int xSteps = destinationPosition.subtractXCoordinate(currentPosition);

            if (ySteps == 1 && (xSteps == 1 || xSteps == -1)) {
                return true;
            }

            return false;


        } else {
            return false;
        }
    }
}
