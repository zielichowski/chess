package com.game.chess.pieces;

import com.game.chess.board.tiles.Position;

public interface Piece {
    void addRule(Rule rule);
    boolean canMove(Position position);
    void move(Position position);
}
