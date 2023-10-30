package test;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import game2048.Board;
import game2048.Board.Direction;

class MoveLeftTest {
	Board board;

	@Test
	void test() {
		Board testboard = new Board();
		testboard.fillManually(2, 1, 2);
		testboard.fillManually(3, 1, 2);
		testboard.move(Direction.LEFT);
		assertEquals(testboard.board[3][1].val,4);
		testboard.print();
	}

}
