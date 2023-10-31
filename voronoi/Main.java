import java.util.ArrayList;
import java.util.Random;

class Main {

	final static int width = 800;
	final static int height = 600;
	final static int numSites = 5;

	public static void main(String args[]) {
		// create a widthxheight image
		PpmImage image = new PpmImage(height, width);
		// we have to do some ugly casts here, b/c a number is interpreted as an int
		ArrayList<Site> siteList = new ArrayList<>(numSites);
		double baseHue = Math.random();
		Random rand = new Random();
		for (int i = 0; i < numSites; i++) {
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			Pixel p = generateRandColour(baseHue);
			siteList.add(new Site(x, y, p));
		}
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int minDist = Integer.MAX_VALUE;
				Site minSite = null;
				for(Site s: siteList) {
					int dist = calcDistance(x, y, s.x, s.y);
					if (dist < minDist) {
						minDist = dist;
						minSite = s;
					}
				} //Now we know Min Distance
				image.setPixel(x, y, minSite.colour);
			}
		}
		image.writeImage("test.ppm");
		// a file "test.ppm" will be created. It can be opened with IrfanView on windows
		System.out.println("Image Done");
	}
	
	private static int calcDistance(int x1, int y1, int x2, int y2) {
		// Returns squared euclidean distance between 2 points
		int dx = (x1 - x2) * (x1 - x2);
		int dy = (y1 - y2) * (y1 - y2);
		return dx + dy;
	}

	public static Pixel generateRandColour(double baseHue) {
		double h = baseHue;
		double s = 0.5; //Math.random();
		double l = Math.random();
		
		return Hsl.hslToRgb(h, s, l);
	}
}
