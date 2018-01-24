package com.game.chess.pieces.pawn.exporter;

import com.game.chess.board.tiles.Position;
import com.game.chess.exporter.Exporter;

public interface PawnExporter extends Exporter {
    void fetchPawnPosition(Position position);
}
