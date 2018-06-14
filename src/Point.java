public class Point {
    private double x;
    private double y;
    private  String name;

    public Point(double x, double y, String name){
        this.x=x;
        this.y=y;
        this.name=name;

    }

    public Point(double x, double y){
        this.x=x;
        this.y=y;
        this.name="P";
    }


    public double distance (Point A){
        double dx=this.x-A.x;
        double dy=this.y-A.y;
        return Math.sqrt(dx*dx+dy*dy);
    }

    public void update (Point B){
        this.x=B.getX();
        this.y=B.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double GetR() {
        return Math.sqrt(x*x + y*y);
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPoint(double x, double y) {
        this.y = y;
        this.x = x;
    }

    public void setPoint(Point p) {
        this.x = p.getX();
        this.y = p.getY();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return (name+"(" + x + "," + y + ")\t");
    }


}

