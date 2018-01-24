package com.game.chess.pieces;

import com.game.chess.board.Board;
import com.game.chess.board.tiles.Position;
import com.game.chess.board.tiles.exporter.SimplePositionExporter;
import com.game.chess.pieces.pawn.Pawn;
import com.game.chess.pieces.pawn.exporter.PawnExporter;
import com.game.chess.pieces.pawn.exporter.SimplePawnExporter;
import com.game.chess.pieces.pawn.rules.AttackRule;
import com.game.chess.pieces.pawn.rules.OneStepForwardRule;
import com.game.chess.pieces.pawn.rules.TwoStepForwardRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PawnTest {
    Position position = new Position(0, 1);
    Piece piece = new Pawn(position);


    @Test
    public void pawnCanMoveOneStepForward() {
        Position dest = new Position(0, 2);
        piece.addRule(new OneStepForwardRule());

        boolean canMoveForward = piece.canMove(dest);
        Assert.assertEquals(true, canMoveForward);

    }

    @Test
    public void pawnCannotMoveOneStepForward() {
        Position dest = new Position(0, 2);
        dest.occupy();
        piece.addRule(new OneStepForwardRule());

        boolean canMoveForward = piece.canMove(dest);
        Assert.assertEquals(false, canMoveForward);
    }

    @Test
    public void pawnCanMoveTwoStepForward() {
        Position dest = new Position(0, 3);
        piece.addRule(new OneStepForwardRule());
        piece.addRule(new TwoStepForwardRule(false));
        boolean canMoveForward = piece.canMove(dest);

        Assert.assertEquals(true, canMoveForward);
    }

    @Test
    public void pawnCannotMoveTwoStepForward() {
        Position dest = new Position(0, 3);
        piece.addRule(new TwoStepForwardRule(true));
        boolean canMoveForward = piece.canMove(dest);

        Assert.assertEquals(false, canMoveForward);
    }

    @Test
    public void pawnCanAttackOnRight() {
        Position dest = new Position(1, 2);
        dest.occupy();
        piece.addRule(new AttackRule());
        boolean canAttack = piece.canMove(dest);

        Assert.assertEquals(true, canAttack);

    }


    @Test
    public void checkPossibleMovementsOnEmptyBoard() {
        Position position = new Position(0, 1);
        Piece piece = new Pawn(position);
        piece.addRule(new OneStepForwardRule());
        piece.addRule(new TwoStepForwardRule(false));
        piece.addRule(new AttackRule());
        Board board = new Board();
        board.addPiece(piece, position);

        List<Position> moves = board.checkPossibleMovements(piece);

        Assert.assertEquals("0,2", moves.get(0).toString(new SimplePositionExporter()));
        Assert.assertEquals("0,3", moves.get(1).toString(new SimplePositionExporter()));


    }

    @Test
    public void checkPossibleMovementsOnEmptyBoardAfterInitMove() {
        Position position = new Position(1, 2);
        Piece piece = new Pawn(position);
        piece.addRule(new OneStepForwardRule());
        piece.addRule(new TwoStepForwardRule(true));
        piece.addRule(new AttackRule());
        Board board = new Board();
        board.addPiece(piece, position);

        List<Position> moves = board.checkPossibleMovements(piece);
        Assert.assertEquals("1,3", moves.get(0).toString(new SimplePositionExporter()));
    }

    @Test
    public void successfullyMoveOnGivenPosition() {
        Position position = new Position(1, 2);
        Pawn piece = new Pawn(position);
        piece.addRule(new OneStepForwardRule());

        piece.move(new Position(1, 3));

        Assert.assertEquals("PawnPosition{1,3}", piece.toString(new SimplePawnExporter())
        );

    }

}
