package com.game.chess.pieces.bishop;

import com.game.chess.board.tiles.Position;
import com.game.chess.exporter.Exportable;
import com.game.chess.pieces.Piece;
import com.game.chess.pieces.bishop.exporters.BishopExporter;

public class Bishop extends Piece implements Exportable<BishopExporter> {

    public Bishop(Position currentPosition) {
        super(currentPosition);
    }

    @Override
    public void export(BishopExporter exporter) {

    }

    @Override
    public String toString(BishopExporter exporter) {
        return null;
    }

}
