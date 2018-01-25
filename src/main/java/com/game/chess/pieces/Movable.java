package com.game.chess.pieces;

import com.game.chess.board.tiles.Position;

public interface Movable {

    boolean canMove(Position position);

    void move(Position position);
}
