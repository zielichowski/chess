package com.game.chess.pieces;

import com.game.chess.board.Board;
import com.game.chess.board.tiles.Position;
import com.game.chess.board.tiles.exporter.SimplePositionExporter;
import com.game.chess.pieces.bishop.Bishop;
import com.game.chess.pieces.bishop.rules.CrossStepRule;
import com.game.chess.pieces.pawn.Pawn;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BishopTest {
    Position position = new Position(1, 1);
    Piece piece = new Bishop(position);

    @Test
    public void bishopCanMoveOneStepCross(){
        Position dest = new Position(2, 2);
        piece.addRule(new CrossStepRule());

        boolean canMoveForward = piece.canMove(dest);
        Assert.assertEquals(true, canMoveForward);

    }

    @Test
    public void bishopCanMoveThreeStepCross(){
        Position dest = new Position(4, 4);
        piece.addRule(new CrossStepRule());

        boolean canMoveForward = piece.canMove(dest);
        Assert.assertEquals(true, canMoveForward);
    }

    @Test
    public void bishopCannotMoveForward(){
        Position dest = new Position(1, 2);
        piece.addRule(new CrossStepRule());

        boolean canMoveForward = piece.canMove(dest);
        Assert.assertEquals(false, canMoveForward);
    }

    @Test
    public void bishopCanMoveCrossBack(){
        Position dest = new Position(0, 0);
        piece.addRule(new CrossStepRule());

        boolean canMoveForward = piece.canMove(dest);
        Assert.assertEquals(true, canMoveForward);
    }

    @Test
    public void bishopCanMoveRightBackCross(){
        Position dest = new Position(2, 0);
        piece.addRule(new CrossStepRule());

        boolean canMoveForward = piece.canMove(dest);
        Assert.assertEquals(true, canMoveForward);
    }

    @Test
    public void bishopCannotSkipAnotherPiece(){
        Board board = new Board();
        Position pawnPos = new Position(2,1);
        Piece pawn = new Pawn(pawnPos);

        Position bishopPos = new Position(1,0);
        Piece bishop = new Bishop(bishopPos);
        bishop.addRule(new CrossStepRule());

        board.addPiece(pawn,pawnPos);
        board.addPiece(bishop,bishopPos);

        List<Position> positions = board.checkPossibleMovements(bishop);
        for (Position position1 : positions) {
            position1.export(new SimplePositionExporter());
        }


    }

}
