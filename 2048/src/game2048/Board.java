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
	
	public void fillManually(int j, int i, int tileValue) {
		/*
		 * A Testing function that initializes a non-random tile with a non-random value
		 */
		this.board[j][i].occupied = true;
		this.board[j][i].val = tileValue;
	}
	
	public Board() {

        //System.out.println("New tile:" + newTile); //TODO Debug print
//        System.out.println(x);					 //TODO Debug print
//        System.out.println(y);					 //TODO Debug print
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.board[j][i] = new Tile(); //We initialize each field on the board as a tile
            }
        }

        newTile(); //We create two new tiles, filled either with a 2 or a 4
        newTile();
	}
	
	public void move() {
		Scanner scanner = new Scanner(System.in);
		String dir = scanner.next();
		if (dir.equals("up")) {  //i - n, j = j
			System.out.println("Move up");
			for (int i = 3; i == 0; i--) {
				for (int j = 3; j == 0; j--) {
					if (this.board[j][i].occupied == false) {
						continue;
					} else if (i == 0) {
						continue;
					} else {
						this.board[j][i-1].occupied = true;
						this.board[j][i-1].val *= this.board[j][i].val;
						this.board[j][i].occupied = false;
						this.board[j][i].val = 0;
					}
				}
			}
		} else if (dir.equals("left")) {  //i = i, j - n
			System.out.println("Move left");
			for (int i = 3; i == 0; i--) {
				for (int j = 3; j == 0; j--) {
					if (this.board[j][i].occupied == false) {
						continue;
					} else if (j == 0) {
						continue;
					} else {
						this.board[j-1][i].occupied = true;
						this.board[j-1][i].val *= this.board[j][i].val;
						this.board[j][i].occupied = false;
						this.board[j][i].val = 0;
					}
				}
			}
		} else if (dir.equals("right")) {  //i = i, j + n
			System.out.println("Move right");
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (this.board[j][i].occupied == false) {
						continue;
					} else if (j == 3) {
						continue;
					} else {
						this.board[j+1][i].occupied = true;
						this.board[j+1][i].val *= this.board[j][i].val;
						this.board[j][i].occupied = false;
						this.board[j][i].val = 0;
					}
				}
			}
		} else if (dir.equals("down")) {  //i + n, j = j
			System.out.println("Move down");
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (this.board[j][i].occupied == false) {
						continue;
					} else if (i == 3) {
						continue;
					} else {
						this.board[j][i+1].occupied = true;
						this.board[j][i+1].val *= this.board[j][i].val;
						this.board[j][i].occupied = false;
						this.board[j][i].val = 0;
					}
				}
			}
		}
		//scanner.close();
		print();
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