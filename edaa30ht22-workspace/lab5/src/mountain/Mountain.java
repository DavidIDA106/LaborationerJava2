package mountain;

import fractal.*;

public class Mountain extends Fractal {
    private Point a;
    private Point b;
    private Point c;

    public Mountain (Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getTitle() {
        return "Mountain triangel";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        turtle.moveTo(a.getX(), a.getY());
		fractalLine(turtle, order, a, b, c);
        /*turtle.moveTo(a.getX(), a.getY());
		fractalLine(turtle, order, Math.hypot((b.getX()-a.getX()), (b.getY()-a.getY())), (int)Math.toDegrees(Math.atan2(b.getY()-a.getY(), b.getX()-a.getX()) * 180 / Math.PI));
		fractalLine(turtle, order, Math.hypot((c.getX()-b.getX()), (c.getY()-b.getY())), (int)Math.toDegrees(Math.atan2(c.getY()-b.getY(), c.getX()-b.getX()) * 180 / Math.PI));
		fractalLine(turtle, order, Math.hypot((a.getX()-c.getX()), (a.getY()-c.getY())), (int)Math.toDegrees(Math.atan2(a.getY()-c.getY(), a.getX()-c.getX()) * 180 / Math.PI)); */
	}

    private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c) {
		if (order == 0) {
			turtle.moveTo(a.getX(), a.getY());
		    turtle.forwardTo(b.getX(), b.getY());
		    turtle.forwardTo(c.getX(), c.getY());
		    turtle.forwardTo(a.getX(), a.getY());
			} else {
                fractalLine(turtle, order - 1, a, b, c);
                fractalLine(turtle, order - 1, a, b, c);
                fractalLine(turtle, order - 1, a, b, c);
                fractalLine(turtle, order - 1, a, b, c);
			}
			
	}
    
}
