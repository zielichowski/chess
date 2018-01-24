package com.game.chess.pieces.pawn;

import com.game.chess.board.tiles.Position;
import com.game.chess.board.tiles.exporter.SimplePositionExporter;
import com.game.chess.pieces.Piece;
import com.game.chess.pieces.Rule;
import com.game.chess.exporter.Exportable;
import com.game.chess.pieces.pawn.exporter.PawnExporter;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece, Exportable<PawnExporter> {
    private List<Rule> rules = new ArrayList<>();
    private Position currentPosition;

    public Pawn(Position currentPosition) {
        this.currentPosition = currentPosition;
    }


    @Override
    public void addRule(Rule rule) {
        rules.add(rule);
    }

    @Override
    public boolean canMove(Position position) {
        for (Rule rule : rules) {
            if (rule.apply(currentPosition, position)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public void move(Position position) {
        if (canMove(position)) {
            currentPosition = position;
        } else {
            throw new RuntimeException("Unable to move on given position : " + position.toString(new SimplePositionExporter()));
        }
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
