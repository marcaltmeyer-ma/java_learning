package game2048;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board {
	Tile[][] board= new Tile[4][4];

	public Board() {
        List<Integer> initList = Arrays.asList(2,4); //A new tile can either be a 2 or a 4, so we need a list to chose from
        Random rand = new Random(); //from https://www.baeldung.com/java-random-list-element

        int x = new Random().nextInt(4);
        int y = new Random().nextInt(4); //x and y are coordinates in the field. When a new tile gets filled, we need a random x and y coordinate, on which the 2 or 4 appears
        int initialTileValue = initList.get(rand.nextInt(initList.size()));
        //System.out.println("New tile:" + newTile);
        System.out.println(x);
        System.out.println(y);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.board[j][i] = new Tile();
            }
        }
        this.board[x][y].val = initialTileValue;
        this.board[x][y].occupied = true;
	}

	public void print() { //https://stackoverflow.com/questions/7782080/how-to-print-a-two-dimensional-array
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(this.board[j][i].val);
			}
		}
	}
}