import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

// class representing a PPM image
// See https://en.wikipedia.org/wiki/Netpbm
class PpmImage {
	private int height;
	private int width;
	private Pixel[][] pixels;

	public PpmImage(int height, int width) {
		this.height = height;
		this.width = width;
		this.pixels = new Pixel[this.height][this.width];
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public Pixel getPixel(int x, int y) {
		return this.pixels[y][x];
	}

	// set the pixel at position (x, y)
	public void setPixel(int x, int y, Pixel pixel) {
		this.pixels[y][x] = pixel;
	}

	// A PPM header consists of
	// - the string "P6" and a newline
	// - the width and height of the image in ASCII numbers seperated by a space
	// and a newline
	// - the color depth (hardcoded to 255 bit here) and a newline
	private void writeHeader(FileOutputStream fos) {
		// PrintWriter to write strings
		PrintWriter pw = new PrintWriter(fos);
		pw.write("P6\n");
		pw.write(Integer.toString(this.width));
		pw.write(" ");
		pw.write(Integer.toString(this.height));
		pw.write("\n");
		pw.write("255");
		pw.write("\n");
		// make sure to flush the stream; otherwise this data might not be written!
		pw.flush();
		// DO NOT close the PrintWriter. That would close the FileOutputStream
		// as well for some reason
	}

	// write a single pixel in order R G B
	private void writePixel(FileOutputStream fos, Pixel pixel) throws IOException {
		fos.write(pixel.r);
		fos.write(pixel.g);
		fos.write(pixel.b);
		fos.flush(); // make sure to flush
	}

	// write this image into the file specified by outputPath
	public void writeImage(String outputPath) {
		try {
			// FileOutputStream to write binary data
			FileOutputStream fos = new FileOutputStream(outputPath);
			writeHeader(fos);

			// for each row, iterate over its colums
			for (int y = 0; y < this.height; y++) {
				for (int x = 0; x < this.width; x++) {
					writePixel(fos, this.pixels[y][x]);
				}
			}

			fos.close();
		} catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}

	}
}
