// provides utility functions to convert from HSL to RGB
class Hsl {
	// helper
	private static double hueToRgb(double p, double q, double t) {
		if (t < 0)
			t += 1;
		if (t > 1)
			t -= 1;
		if (t < 1 / 6.0)
			return p + (q - p) * 6 * t;
		if (t < 1 / 2.0)
			return q;
		if (t < 2 / 3.0)
			return p + (q - p) * (2 / 3.0 - t) * 6;
		return p;
	}

	// convert HSL value to RGB Pixel
	public static Pixel hslToRgb(double h, double s, double l) {
		double r, g, b;

		if (s == 0.0) {
			r = g = b = l;
		} else {
			double q = l < 0.5 ? l * (1 + s) : l + s - l * s;
			double p = 2 * l - q;

			r = hueToRgb(p, q, h + 1 / 3.0);
			g = hueToRgb(p, q, h);
			b = hueToRgb(p, q, h - 1 / 3.0);
		}

		Pixel rgb = new Pixel();
		// we need to explicitly cast to byte here
		rgb.r = (byte) Math.round(r * 255);
		rgb.g = (byte) Math.round(g * 255);
		rgb.b = (byte) Math.round(b * 255);

		return rgb;
	}
}
