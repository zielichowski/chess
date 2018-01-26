package com.game.chess.pieces;

import com.game.chess.board.tiles.Position;
import com.game.chess.board.tiles.exporter.SimplePositionExporter;
import com.game.chess.players.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece implements Movable {

    private List<Rule> rules = new ArrayList<>();
    protected Position currentPosition;
    protected Color color;

    public Piece(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Piece(Position currentPosition, Color color) {
        this.currentPosition = currentPosition;
        this.color = color;
    }

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
}
