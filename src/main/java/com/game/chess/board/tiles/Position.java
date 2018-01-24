package com.game.chess.board.tiles;

import com.game.chess.board.tiles.exporter.PositionExporter;
import com.game.chess.exporter.Exportable;

public class Position implements Exportable<PositionExporter> {
    private int x;
    private int y;
    private boolean occupied = false;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int subtractXCoordinate(Position other) {
        return this.x - other.x;
    }

    public int subtractYCoordinate(Position other) {
        return this.y - other.y;
    }

    public void occupy() {
        occupied = true;
    }

    public void release() {
        occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public void export(PositionExporter exporter) {
        exporter.fetchCoordinateX(x);
        exporter.fetchCoordinateY(y);
        exporter.export();
    }

    @Override
    public String toString(PositionExporter exporter) {

        exporter.fetchCoordinateX(x);
        exporter.fetchCoordinateY(y);

        return exporter.toString();
    }
}
