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
        List<Position> moves = new ArrayList<>();
        Position piecePosition = piecesWithPositions.get(piece);


        for (Position position : positions) {
            if (piece.canMove(position)) {
                if (!hasToSkip(piecePosition, position)) {
                    moves.add(position);
                } else {
                    if (piece.isSkipable()) {
                        moves.add(position);
                    }
                }
            }

        }
        return moves;
    }

    private boolean hasToSkip(Position piecePosition, Position position) {

    }

    private void occupyPosition(Position position) {
        positions.get(positions.indexOf(position)).occupy();
    }
}
