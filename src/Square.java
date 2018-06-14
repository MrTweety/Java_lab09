import java.awt.*;
import java.util.Random;

public class Square  {
    private Point A;
    private Point B;
    private Point C;
    private Point D;
    double size, speed;
    private Color figureColor;
    Random generator = new Random();


    Square(Point A,Point B, Point C,Point D){
        this.A=new Point(A.getX(),A.getY(),A.getName());
        this.B=new Point(B.getX(),B.getY(),B.getName());
        this.C=new Point(C.getX(),C.getY(),C.getName());
        this.D=new Point(D.getX(),D.getY(),D.getName());

        this.setColor(new Color(generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));

    }

    Square(double left, double top, double size){
        this.size = size;
        this.A=new Point( left, top );
        this.B=new Point(left + size, top );
        this.C=new Point(left + size,top + size );
        this.D=new Point( left, top + size );
        this.setColor(new Color(generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));
        this.speed = 0.5;

    }

    public void setPosition(double left, double top) {
        A.setX(left);
        D.setX(left);
        A.setY(top);
        B.setY(top);
        B.setX(left + size);
        C.setX(left + size);
        C.setY(top + size);
        D.setY(top + size);
    }


    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getLeft() {
        return A.getX();
    }

    public double getTop() {
        return A.getY();
    }

    public void setLeft(double left) {
        A.setX(left);
        D.setX(left);
        B.setX(left + size);
        C.setX(left + size);
    }

    public void setTop(double top) {
        A.setY(top);
        B.setY(top);
        C.setY(top + size);
        D.setY(top + size);
    }




    public void drawFigure(Graphics g){
        g.setColor(figureColor);
        int []PointX ={(int)A.getX(),(int)B.getX(),(int)C.getX(),(int)D.getX()};
        int []PointY ={(int)A.getY(),(int)B.getY(),(int)C.getY(),(int)D.getY()};

        g.drawPolygon(PointX, PointY, 4);
        g.fillPolygon(PointX, PointY, 4);

    }


    public void setColor(Color color) {
        this.figureColor = color;
    }



    @Override
    public String toString() {
        return ("Quadrangle: " + A + B + C + D);
    }


    //******************************************************************************************
    public double diagonalAC(){
        return C.distance(A);
    }

    public double diagonalBD(){
        return D.distance(B);
    }


    public Point getA() {
        return A;
    }

    public Point getC() {
        return C;
    }

    public Point getB() {
        return B;
    }

    public Point getD() {
        return D;
    }

    //***********************************************************************************


    public void setC(Point c) {
        C = c;
    }

    public void setB(Point b) {
        B = b;
    }

    public void setA(Point a) {
        A = a;
    }

    public void setD(Point d) {
        D = d;
    }


}

