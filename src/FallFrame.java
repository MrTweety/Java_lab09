import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FallFrame {


    final static int startNumber = 10;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                int screenHeight = screen.height;
                int screenWidth = screen.width;

                SquareFrame window = new SquareFrame();
                window.setLocationRelativeTo(null);
                window.setTitle("Mateusz");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setSize(screenWidth / 2, screenHeight / 2);

                window.setVisible(true);
              //generowanie startowych kwadratów
                for (int i =0; i<startNumber;i++)
                    window.addSquare();

            }
        });


    }//end main

}



//klasa implemantujaca interfejs Runable i tworzaca animacje spadania
class SquareRunnable implements Runnable {

    private Square square;
    private SquareComponent component;
    private Timer timer;


    SquareRunnable(Square aSquare, SquareComponent aComponent) {
        this.square = aSquare;
        this.component = aComponent;
        this.timer = new Timer(10, timerAction);

    }

    private ActionListener timerAction = new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            square.move(component.getSize());
            component.repaint();

        }
    };


    @Override
    public void run() {
        try {
            component.repaint();
            timer.start();
            while (true) {

                if (component.isRunning)
                    timer.start();
                else
                    timer.stop();
                //component.repaint();
                Thread.sleep(10);
                //square.move(component.getSize());
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}


//Ranka z panelem i przyciskami
class SquareFrame extends JFrame {

    private SquareComponent comp;
    int size = 20;


    public SquareFrame() {




        comp = new SquareComponent();
        comp.setBackground(new Color(244, 134, 0));
        add(comp, BorderLayout.CENTER);
        JPanel buttonPannel = new JPanel();
        comp.isRunning = true;


        addButton(buttonPannel, "ADD NEXT SQUARE", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSquare();
            }
        });




        addButton(buttonPannel, "Stop", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                comp.isRunning = false;
            }
        });

        addButton(buttonPannel, "Start", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                comp.isRunning = true;
            }
        });

        addButton(buttonPannel, "Exit", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPannel.setBackground(new Color(40, 240, 255));
        add(buttonPannel, BorderLayout.SOUTH);
        pack();

    }



    //Dodaj przycisk do kontenera
    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    //Dodaj kwadrat i uruchom wątek odpowiedzialny ze jej spadanie
    public void addSquare() {
        Square sq = new Square(comp.getSize(), size);
        comp.add(sq);
        Runnable r = new SquareRunnable(sq, comp);
        Thread t = new Thread(r);
        t.start();
    }
}













