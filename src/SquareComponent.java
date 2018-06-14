import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

//klasa implemantujaca interfejs Runable i tworzaca animacje spadania
public class SquareComponent extends JPanel{

    List<Square> squareList;
    public static boolean isRunning;

    SquareComponent(){
        squareList = new ArrayList<Square>();
    }

    public void add(Square sq){
        squareList.add(sq);
    }

    @Override


    public void paintComponent(Graphics g) {
        super.paintComponent(g);//czyszczenie tła
        squareList.forEach(p -> {
            p.drawFigure(g);
        });

    }

}


