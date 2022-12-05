package laba4_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class task1_2 extends Component{
    private JLabel registration = new JLabel("РЕЄСТРАЦІЯ");
    private JLabel name = new JLabel("Ім'я");
    private JLabel sex = new JLabel("Стать");
    private JLabel email = new JLabel("Е-mail");
    private JLabel country = new JLabel("Країна");
    private JLabel iconLabel;

    private JTextField inputName = new JTextField("", 5);
    private JTextField inputEmail = new JTextField("", 5);


    private JRadioButton r1 = new JRadioButton("чоловік");
    private JRadioButton r2 = new JRadioButton("жінка");
    private JButton button = new JButton("Зареєструватися");

    private String[] countries = {
            "Виберіть країну проживання",
            "Австрія",
            "Бельгія",
            "Велика Британія",
            "Данія",
            "Іспанія",
            "Італія",
            "Монако",
            "Португалія",
            "Україна",
            "Швеція"
    };
    private JComboBox cb = new JComboBox(countries);

    private void run() {
        JFrame frame = createFrame();
        frame.setVisible(true);
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame("pomogite");
        frame.getContentPane().add(createPanel());
        frame.pack();
        frame.setBounds(500,200,650,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridBagLayout());

        ImageIcon iconLogo = new ImageIcon("D:\\imgonline-com-ua-Resize-AINRJLDBiM06x.jpg");
        //System.out.println(iconLogo.getIconWidth()+" "+iconLogo.getIconHeight());
        iconLabel = new JLabel("lox");
        iconLabel.setIcon(iconLogo);
        iconLabel.setBounds(0, 0, iconLogo.getIconWidth(), iconLogo.getIconHeight());
        panel.add(iconLabel);

        Color textColor = new Color(42, 162, 8, 255);
        registration.setBounds(350, 10, 500, 50);
        registration.setForeground(textColor);
        registration.setFont(new Font("Times New Roman", Font.BOLD, 24));
        panel.add(registration);

        name.setBounds(iconLogo.getIconWidth()+20, 60, 50,50);
        name.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        panel.add(name);

        inputName.setBounds(iconLogo.getIconWidth()+130, 75, 200,30);
        inputName.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(inputEmail.getText().isEmpty() || inputName.getText().isEmpty() || cb.getSelectedIndex() == 0)
                    button.setEnabled(false);
                else{
                    button.setEnabled(true);
                }
            }
        });
        panel.add(inputName);

        sex.setBounds(iconLogo.getIconWidth()+20, 130, 100,50);
        sex.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        panel.add(sex);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        r1.setBounds(iconLogo.getIconWidth()+130,150,100,25);
        panel.add(r1);
        r1.setSelected(true);
        r1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iconLabel.setIcon(new ImageIcon("D:\\imgonline-com-ua-Resize-AINRJLDBiM06x.jpg"));
            }
        });

        r2.setBounds(iconLogo.getIconWidth()+130,180,100,25);
        r2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iconLabel.setIcon(new ImageIcon("D:\\imgonline-com-ua-Resize-EFIqSpYR1W5O.jpg"));
            }
        });
        panel.add(r2);

        email.setBounds(iconLogo.getIconWidth()+20, 210, 100,50);
        email.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        panel.add(email);

        inputEmail.setBounds(iconLogo.getIconWidth()+130, 220, 200,30);
        inputEmail.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(inputEmail.getText().isEmpty() || inputName.getText().isEmpty() || cb.getSelectedIndex() == 0)
                    button.setEnabled(false);
                else{
                    button.setEnabled(true);
                }
            }
        });
        panel.add(inputEmail);

        country.setBounds(iconLogo.getIconWidth()+20, 260, 100,50);
        country.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        panel.add(country);

        cb.setEditable(true);
        cb.setBounds(iconLogo.getIconWidth()+20, 320, 200, 25);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(inputEmail.getText().isEmpty() || inputName.getText().isEmpty() || cb.getSelectedIndex() == 0)
                    button.setEnabled(false);
                else{
                    button.setEnabled(true);
                }
            }
        });
        panel.add(cb);

        button.setBounds(350, 400, 250, 50);
        button.addActionListener(this::actionPerformed);
        button.setEnabled(false);

        if(!(inputName.getText().isEmpty() && inputEmail.getText().isEmpty() && cb.getSelectedIndex()==0)){
            button.setEnabled(false);
        }
        panel.add(button);



        panel.setLayout(null);
        return panel;
    }
//
//
    public void actionPerformed(ActionEvent e) {
        Pattern checkName = Pattern.compile("^[а-яА-Я]*$");
        Matcher matcher1 = checkName.matcher(inputName.getText());

        Pattern checkEmail = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher2 = checkEmail.matcher(inputEmail.getText());



        if (!matcher1.matches()) {
            JOptionPane.showMessageDialog(this, "Введіть корректне ім'я", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!matcher2.matches()) {
            JOptionPane.showMessageDialog(this, "Використовуйте корректний формат email!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            JFrame f = new JFrame();
            f.getContentPane().add(createPanel());
            f.pack();
            f.setBounds(600,300,300,200);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

            JPanel p = new JPanel(new GridBagLayout());
            f.add(p);

            JLabel l = new JLabel("Активація успішна!");
            l.setBounds(20,20,500,50);
            p.add(l);

            JButton b1 = new JButton("Підтвердити");
            b1.setBounds(20,100,110,25);
            p.add(b1);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            JButton b2 = new JButton("Скасувати");
            b2.setBounds(150,100,110,25);
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            p.add(b2);


            p.setLayout(null);
        }

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new task1_2().run());

    }

}

