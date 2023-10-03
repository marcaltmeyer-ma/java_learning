package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game2048.Board;

class MoveLeftTest {
	Board board;
	@Test
	void test() {
		board.fillManually(2, 1, 2);
		board.fillManually(3, 1, 2);
		board.move();
		assertEquals(board[1][3], 4);;
	}

}
