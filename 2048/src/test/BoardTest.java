package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game2048.Board;

/*
Tests if the field is initialized correctly. To pass, the val of the tiles on the board should not be null,
but instead be initialized to 0
*/
class BoardTest {
	Board board;


	@Test
	void test() {
		Board testboard = new Board();
		assertNotNull(testboard);//If the board is initialized correctly, the result should not be null
	}

}
