package mountain;

public class Side {
    private Point a, b;
    public Side(Point a, Point b){
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj == null || this == null){
            return false;
        }
        return false;
    }
    
}
