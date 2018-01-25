package com.game.chess.pieces.pawn;

import com.game.chess.board.tiles.Position;
import com.game.chess.exporter.Exportable;
import com.game.chess.pieces.Piece;
import com.game.chess.pieces.pawn.exporter.PawnExporter;

public class Pawn extends Piece implements Exportable<PawnExporter> {

    public Pawn(Position currentPosition) {
        super(currentPosition);
    }

    @Override
    public void export(PawnExporter exporter) {

    }

    @Override
    public String toString(PawnExporter exporter) {
        exporter.fetchPawnPosition(currentPosition);
        return exporter.toString();
    }
}
