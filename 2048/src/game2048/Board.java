package game2048;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Board {
	Tile[][] board= new Tile[4][4];

//	private Tile fillTile(int x, int y, Random rand, int val, Tile tile) {
//		if (tile.occupied == false) {
//			System.out.println("if case");
//			tile.val = val;
//			tile.occupied = true;
//			return tile;			
//		} else {
//			int newX = rand.nextInt(4);
//			int newY = rand.nextInt(4);
//			return fillTile(newX, newY, rand, val, tile);
//		}
//	}
	
	public void newTile() {
		Random rnd = new Random();
//		int[] possibleValues = new int[2];
//		possibleValues[0] = 2;
//		possibleValues[1] = 4;
		List<Integer> possibleValues = Arrays.asList(2,4);

		ArrayList<Tile> emptyTiles = new ArrayList<>();
		for (int i = 0; i < this.board[0].length; i++) {
			for (int j = 0; j < this.board.length; j++) {
				Tile t = this.board[j][i];
				if (t.occupied == false) {
					emptyTiles.add(t);
				}
			} //for (int j = 0; j < this.board.length; j++) {
		}
		Tile randomTile = emptyTiles.get(rnd.nextInt(emptyTiles.size()));
		randomTile.occupied = true;
		int randomValue = possibleValues.get(rnd.nextInt(possibleValues.size())); //https://www.baeldung.com/java-random-list-element
		randomTile.val = randomValue;
	}
	
	public Board() {
        List<Integer> initList = Arrays.asList(2,4); //A new tile can either be a 2 or a 4, so we need a list to chose from
        //Random rand = new Random(); //from https://www.baeldung.com/java-random-list-element

        //int x = new Random().nextInt(4);
        //int y = new Random().nextInt(4); //x and y are coordinates in the field. When a new tile gets filled, we need a random x and y coordinate, on which the 2 or 4 appears
        //int initialTileValue = initList.get(rand.nextInt(initList.size()));
        //System.out.println("initialTileValue " + initialTileValue);
        //System.out.println("New tile:" + newTile); TODO Debug print
//        System.out.println(x);					 TODO Debug print
//        System.out.println(y);					 TODO Debug print
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.board[j][i] = new Tile();
            }
        }

        newTile();
        newTile();
	}
	
	public Board move(Board gameboard) {
		Scanner direction = new Scanner(System.in);
		String dir = direction.next();
		if (dir.equals("up")) {
			System.out.println("Move up");
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.println(gameboard[j][i]);
				}
			}
		} else if (dir.equals("left")) {
			System.out.println("Move left");
		} else if (dir.equals("right")) {
			System.out.println("Move right");
		} else if (dir.equals("down")) {
			System.out.println("Move down");
		}
		//direction.close();
		gameboard.print();
		return gameboard;
	}
	
	public void print() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(this.board[j][i].val + " ");
			}
			System.out.println();
		}
	}
}