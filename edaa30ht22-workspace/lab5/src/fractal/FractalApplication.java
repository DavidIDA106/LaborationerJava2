package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain(new Point(200, 150), new Point(150, 200), new Point(350, 150));
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
