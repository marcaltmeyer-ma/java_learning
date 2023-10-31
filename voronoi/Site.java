
public class Site {
	public int x;
	public int y;
	public Pixel colour;
	
	public Site() {
		x = 0;
		y = 0;
		colour = new Pixel();
	}
	
	public Site(int x, int y, Pixel colour) {
		this.x = x;
		this.y = y;
		this.colour = colour;
	}

}
