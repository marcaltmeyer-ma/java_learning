package game2048;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Board {
	Tile[][] board= new Tile[4][4];

	
	public void newTile() {
		/*
		 * Initializes new tile:
		 * When the player moves a tile without adding it up with another, a new tile is randomly filled with either 
		 * a 2 or a 4
		  */
		 
		Random rnd = new Random();  //Creating a random object which is needed later
		List<Integer> possibleValues = Arrays.asList(2,4); //A newly appearing tile can have the values 2 or 4. In order to make sure this happens, we initialize a list with the elements 2 and 4

		ArrayList<Tile> emptyTiles = new ArrayList<>(); //A list to collect all empty tiles on the board
		for (int i = 0; i < this.board[0].length; i++) {
			for (int j = 0; j < this.board.length; j++) { //We go through each tile on the board and
				Tile t = this.board[j][i];				  //transform it into a tile
				if (t.occupied == false) {				  //If the current tile is not occupied, we add it to above list
					emptyTiles.add(t);
				}
			} //for (int j = 0; j < this.board.length; j++) {
		}
		Tile randomTile = emptyTiles.get(rnd.nextInt(emptyTiles.size())); //We take a random tile from the list of unoccupied tiles
		randomTile.occupied = true; 									  //The random tile is now occupied, and is randomly assigned a value from the list above
		int randomValue = possibleValues.get(rnd.nextInt(possibleValues.size())); //https://www.baeldung.com/java-random-list-element
		randomTile.val = randomValue;
	}
	
	public Board() {

        //System.out.println("New tile:" + newTile); TODO Debug print
//        System.out.println(x);					 TODO Debug print
//        System.out.println(y);					 TODO Debug print
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.board[j][i] = new Tile(); //We initialize each field on the board as a tile
            }
        }

        newTile(); //We create two new tiles, filled either with a 2 or a 4
        newTile();
	}
	
	public Board move(Board gameboard) {
		Scanner direction = new Scanner(System.in);
		String dir = direction.next();
		if (dir.equals("up")) {
			System.out.println("Move up");
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.println(gameboard.board[j][i]);
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