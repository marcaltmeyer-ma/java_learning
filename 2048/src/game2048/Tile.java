package game2048;

public class Tile {
	
	public int val; //The tiles' numerical value
	public boolean occupied; //Is the tile free or occupied?

    public Tile() {
        this.val = 0; //val is initialized as 0
        this.occupied = false; //tiles are initially unoccupied
    }
}