package laba6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


public class babybe {

    public static String findMax(String x, String y, String z) {
        String[] xArr = x.replaceAll("\\s","").split(",");
        String[] yArr = y.replaceAll("\\s","").split(",");
        String[] zArr = z.replaceAll("\\s","").split(",");

        double[] sqrArr = {Double.parseDouble(xArr[1]), Double.parseDouble(yArr[1]), Double.parseDouble(zArr[1])};
        if (sqrArr[0] > sqrArr[1] && sqrArr[0] > sqrArr[2]) return x;
        else if (sqrArr[1] > sqrArr[0] && sqrArr[1] > sqrArr[2]) return y;
        else if (sqrArr[2] > sqrArr[0] && sqrArr[2] > sqrArr[1]) return z;
        else return null;
    }

    public static void main(String[] args) throws IOException {


        String ua_map = "D:\\papaleftme\\Ukr_Vysh.jpg";
        String world_map = "D:\\papaleftme\\rsz_world-map-in-ukrainian-hd_1.jpg";

        ImageIcon ii = new ImageIcon(world_map);
        JFrame jFrame = new JFrame();
        jFrame.setBounds(400, 200, 800, 600);
        jFrame.setVisible(true);

        JPanel jPanel = new JPanel(new FlowLayout());
        jFrame.add(jPanel);
        jPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));

        jPanel.add(Box.createVerticalStrut(30));

        JLabel mainLabel = new JLabel();

        JMenuBar jMenuBar = new JMenuBar();
        JMenu programMenu = new JMenu("Програма");
        JMenu editMenu = new JMenu("Правка");
        jMenuBar.add(programMenu);
        jMenuBar.add(editMenu);
        jFrame.setJMenuBar(jMenuBar);
        JMenuItem check = programMenu.add(new JMenuItem("Перевірка"));

        JMenuItem calculate = programMenu.add(new JMenuItem("Обчислити"));


        programMenu.add(new JSeparator());
        JMenuItem quit = programMenu.add(new JMenuItem("Вийти"));
        quit.addActionListener(actionEvent -> System.exit(0));

        editMenu.add(new JMenuItem("Копіювати"));
        editMenu.add(new JMenuItem("Вставити"));


        JLabel loveua = new JLabel("Я ЛЮБЛЮ УКРАЇНУ!");

        mainLabel.add(loveua);
        loveua.setBounds(200, 200, 400, 200);
        loveua.setFont(new Font("Arial", Font.BOLD, 40));
        loveua.setForeground(Color.BLUE);
        loveua.setVisible(false);

        mainLabel.setIcon(ii);
        mainLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPopupMenu contextMenu = new JPopupMenu();
                JMenuItem ukraine = new JMenuItem("Україна");
                JMenuItem delete = new JMenuItem("Видалити");
                JMenuItem iloveukraine = new JMenuItem("Я люблю Україну!");

                ukraine.addActionListener(e12 -> mainLabel.setIcon(new ImageIcon(ua_map)));

                iloveukraine.addActionListener(e1 -> loveua.setVisible(true));

                delete.addActionListener(e13 -> mainLabel.setIcon(null));

                contextMenu.add(ukraine);
                contextMenu.add(delete);
                contextMenu.add(iloveukraine);

                contextMenu.show(e.getComponent(), e.getX(), e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e){}
            @Override
            public void mouseReleased(MouseEvent e){}
            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}
        });

        jPanel.add(mainLabel);
        JPanel inputPanel = new JPanel();
        JLabel firstText = new JLabel("Перша: ");
        JTextField firstInput = new JTextField("Назва, площа", 15);
        JLabel secondText = new JLabel("Друга: ");
        JTextField secondInput = new JTextField("Назва, площа", 15);
        JLabel thirdText = new JLabel("Третя: ");
        JTextField thirdInput = new JTextField("Назва, площа", 15);

        inputPanel.add(firstText);
        inputPanel.add(firstInput);
        inputPanel.add(secondText);
        inputPanel.add(secondInput);
        inputPanel.add(thirdText);
        inputPanel.add(thirdInput);

        jPanel.add(inputPanel);

        calculate.addActionListener(actionEvent -> {
            try {

                String firstCountry = firstInput.getText();
                String secondCountry = secondInput.getText();
                String thirdCountry = thirdInput.getText();

                String maxCountry = findMax(firstCountry, secondCountry, thirdCountry);
                if (maxCountry != null) {
                    JFrame jFrame2 = new JFrame();
                    jFrame2.setBounds(400, 100, 500, 200);
                    jFrame2.setVisible(true);
                    JPanel jPanel2 = new JPanel(new FlowLayout());
                    jPanel2.add(new JLabel("Найбільша країна - " + maxCountry));
                    jFrame2.add(jPanel2);
                    jPanel2.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
                    JButton exitButton = new JButton("Вихід");

                    jPanel2.add(exitButton);
                    exitButton.addActionListener(actionEvent1 -> System.exit(0));
                } else {
                    JOptionPane.showMessageDialog(null, "Некоректний формат вводу.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Некоректний формат вводу.");
            }
        });


        check.addActionListener(actionEvent -> {
            try {

                String firstCountry = firstInput.getText();
                String secondCountry = secondInput.getText();
                String thirdCountry = thirdInput.getText();

                String[] firstArr = firstCountry.replaceAll("\\s","").split(",");
                String[] secondArr = secondCountry.replaceAll("\\s","").split(",");
                String[] thirdArr = thirdCountry.replaceAll("\\s","").split(",");

                if (Double.parseDouble(firstArr[1]) <= 0 || Double.parseDouble(secondArr[1]) <= 0
                        || Double.parseDouble(thirdArr[1]) <= 0) {
                    JOptionPane.showMessageDialog(null, "Помилка в даних.");
                } else {
                    JOptionPane.showMessageDialog(null, "Дані коректні.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Помилка в даних.");
            }

        });

        JButton but1 = new JButton("Далі");
        jPanel.add(but1);

        but1.addActionListener(actionEvent -> {
            try {

                String firstCountry = firstInput.getText();
                String secondCountry = secondInput.getText();
                String thirdCountry = thirdInput.getText();

                String maxCountry = findMax(firstCountry, secondCountry, thirdCountry);
                if (maxCountry != null) {
                    JFrame jFrame2 = new JFrame();
                    jFrame2.setBounds(400, 100, 500, 200);
                    jFrame2.setVisible(true);
                    JPanel jPanel2 = new JPanel(new FlowLayout());
                    jPanel2.add(new JLabel("Найбільша країна - " + maxCountry));
                    jFrame2.add(jPanel2);
                    jPanel2.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
                    JButton exitButton = new JButton("Вихід");

                    jPanel2.add(exitButton);
                    exitButton.addActionListener(actionEvent1 -> System.exit(0));
                } else {
                    JOptionPane.showMessageDialog(null, "Некоректний формат вводу.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Помилка в даних.");
            }
        });


        jPanel.revalidate();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
