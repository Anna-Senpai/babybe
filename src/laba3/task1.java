package laba3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class task1 extends JFrame {
    public task1(){
        super("sex?");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,150);
        setVisible(true);
        setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 250, Toolkit.getDefaultToolkit().getScreenSize().height/2 - 250, 500, 500);
        Container c = getContentPane();


        c.add(new bye());

    }
    public static void main(String[] args) {
        Frame fr = new task1();

    }

    static class bye extends JComponent{
        @Override
        protected void paintComponent(Graphics graf){

            super.paintComponent(graf);

            Graphics2D g = (Graphics2D)graf;

            g.setColor(Color.darkGray);
            g.setFont(new Font("", Font.BOLD, 14));
            g.drawString("anna senpai <3",350, 20);

            g.setColor(Color.RED);
            g.setFont(new Font("", Font.BOLD, 20));
            g.drawString("Mama break",150, 20);

            g.setColor(Color.white);
            int x[] = {10, 410, 410, 10};
            int y[] = {30, 30 ,430, 430};
            g.fillPolygon(x,y,4);


            Ellipse2D.Double circle = new Ellipse2D.Double(50, 50, 300, 300);
            g.setColor(Color.LIGHT_GRAY);
            g.fill(circle);

            g.setColor(Color.PINK);
            x = new int[]{160, 200, 300};
            y = new int[]{160, 260, 300};
            g.fillPolygon(x,y,3);

        }
    }
}
