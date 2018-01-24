package com.game.chess.board.tiles.exporter;

import com.game.chess.exporter.Exporter;

public interface PositionExporter extends Exporter {
    void fetchCoordinateX(int x);

    void fetchCoordinateY(int y);

}
