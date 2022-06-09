package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    public static String UName;
    JFrame frm;
    JLabel Wel;
    JLabel bg;
    JTextField Name;

    public Login() {

        frm = new JFrame("Login");
        frm.setSize(1600, 900);
        frm.setLocationRelativeTo(null);

        ImageIcon bgimg = new ImageIcon("login2.jpg");
        Image img = bgimg.getImage();
        Image temp_img = img.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
        bgimg = new ImageIcon(temp_img);
        bg = new JLabel("", bgimg, JLabel.CENTER);
        bg.setBounds(0, 0, 1600, 900);
        frm.add(bg);

        frm.setLayout(new FlowLayout());
        frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
        frm.setVisible(true);

        JButton exit = new JButton("Exit");
        exit.setBounds(50, 20, 100, 30);
        bg.add(exit);

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);

            }
        });

        JButton about = new JButton("About us");
        about.setBounds(1425, 20, 120, 30);
        bg.add(about);

        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new About_us();
                frm.dispose();
            }
        });

        JLabel Username = new JLabel("Username");
        Username.setBounds(702, 400, 300, 50);
        Username.setForeground(Color.white);
        Username.setFont(new Font("MuseoSansRounded100", Font.BOLD, 40));
        bg.add(Username);

        Name = new JTextField(15);
        Name.setFont(new Font("Lato", Font.PLAIN, 20));
        Name.setBounds(650, 480, 300, 30);
        Name.addActionListener(this);
        bg.add(Name);

        JButton Lessgo = new JButton("Let's Go!");
        Lessgo.setBounds(750, 540, 100, 40);
        bg.add(Lessgo);
        Lessgo.addActionListener(this);

    } // constructor

    public void actionPerformed(ActionEvent ae) {

        if (Name.getText().length() == 0)
            JOptionPane.showMessageDialog(null, "Enter an USERNAME!");
        else{
            new Welcome(Name.getText());
            frm.dispose();
            }
        }

    

}