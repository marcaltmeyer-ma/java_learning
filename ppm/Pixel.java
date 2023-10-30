// A class representing an RBG pixel
class Pixel {
	public byte r; // red
	public byte g; // green
	public byte b; // blue

	// I think that's not how you do it in Java
	// but it shows my intent very well ;)
	public Pixel() {
		this.r = 0;
		this.g = 0;
		this.b = 0;
	}

	public Pixel(byte r, byte g, byte b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
}
