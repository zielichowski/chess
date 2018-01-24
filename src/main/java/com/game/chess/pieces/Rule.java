package com.game.chess.pieces;

import com.game.chess.board.tiles.Position;

public interface Rule {

    boolean apply(Position currentPosition, Position destinationPosition);
}
