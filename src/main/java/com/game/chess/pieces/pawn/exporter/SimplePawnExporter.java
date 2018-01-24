package com.game.chess.pieces.pawn.exporter;

import com.game.chess.board.tiles.Position;
import com.game.chess.board.tiles.exporter.SimplePositionExporter;

public class SimplePawnExporter implements PawnExporter {

    private String toExport = "";

    @Override
    public void fetchPawnPosition(Position position) {
        toExport += position.toString(new SimplePositionExporter());
    }

    @Override
    public void export() {
        System.out.println(toExport);
    }

    @Override
    public String toString() {
        return "PawnPosition{" + toExport + '\'' + '}';
    }
}
