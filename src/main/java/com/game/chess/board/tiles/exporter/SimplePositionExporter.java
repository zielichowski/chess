package com.game.chess.board.tiles.exporter;


public class SimplePositionExporter implements PositionExporter {

    private String toExport = "";

    @Override
    public void fetchCoordinateX(int x) {
        toExport += x + ",";
    }

    @Override
    public void fetchCoordinateY(int y) {
        toExport += y;
    }

    @Override
    public void export() {
        System.out.println(toExport);
    }

    @Override
    public String toString() {
        return toExport;
    }
}
