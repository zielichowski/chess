package com.game.chess.pieces.bishop.rules;

import com.game.chess.board.tiles.Position;
import com.game.chess.pieces.Rule;

public class CrossStepRule implements Rule {
    @Override
    public boolean apply(Position currentPosition, Position destinationPosition) {
        int ySteps = Math.abs(destinationPosition.subtractYCoordinate(currentPosition));
        int xSteps = Math.abs(destinationPosition.subtractXCoordinate(currentPosition));

        if (ySteps == xSteps ) {
            return true;
        }

        return false;


    }
}
