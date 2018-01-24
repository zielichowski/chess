package com.game.chess.exporter;

public interface Exportable<T extends Exporter> {
    void export(T exporter);

    String toString(T exporter);
}
