package game2048;

import game2048.Board.Direction;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		board.print();
		Direction direction;
		try {
			direction = Board.getDirectionFromInput();
			board.move(direction);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}