package com.game.chess.board;

import com.game.chess.board.tiles.Position;
import com.game.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private List<Piece> pieces = new ArrayList<>();
    private List<Position> positions = new ArrayList<>(64);
    private Map<Piece, Position> piecesWithPositions = new HashMap<>();


    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                positions.add(new Position(i, j));
            }
        }
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);
        piecesWithPositions.remove(piece);
    }

    public void addPiece(Piece piece, Position position) {
        piecesWithPositions.put(piece, position);
        occupyPosition(position);
    }

    public Piece selectPiece(Piece piece) {
        return pieces.get(pieces.indexOf(piece));
    }

    public List<Position> checkPossibleMovements(Piece piece) {
        List<Position> potentiallyMoves = new ArrayList<>();
        for (Position position : positions) {
            if (piece.canMove(position)) {
                potentiallyMoves.add(position);
            }

        }

        List<Position> finalMoves = filterPotentiallyMoves(potentiallyMoves, piece);

        return potentiallyMoves;
    }

    private List<Position> filterPotentiallyMoves(List<Position> potentiallyMoves, Piece piece) {

        List<Position> finalMoves = new ArrayList<>(potentiallyMoves.size());

        Position piecePosition = piecesWithPositions.get(piece);

        for (Position potentiallyMove : potentiallyMoves) {
            if (!causeCheck(piecePosition, potentiallyMove)) {
                if (!hasToSkip(piecePosition, potentiallyMove)) {
                    checkOccupation(finalMoves, potentiallyMove);
                } else {
                    if (canSkip(piece)) {
                        checkOccupation(finalMoves, potentiallyMove);
                    }
                }
            }
        }


        return null;
    }

    private void checkOccupation(List<Position> finalMoves, Position potentiallyMove) {
        if (!isOccupied(potentiallyMove)) {
            finalMoves.add(potentiallyMove);
        } else {
            if (!occupiedByThisSameColor(potentiallyMove)) {
                finalMoves.add(potentiallyMove);
            }
        }
    }

    private void occupyPosition(Position position) {
        positions.get(positions.indexOf(position)).occupy();
    }
}
