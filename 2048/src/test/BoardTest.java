package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game2048.Board;

class BoardTest {
	Board board;

//	@BeforeEach
//	void setUp() {
//		Board testboard = new Board();
//	}

	@Test
	void test() {
		Board testboard = new Board();
		testboard.InitField();
		assertNotNull(testboard); //If the board is initialized correctly, the result should not be null 
	}

}
