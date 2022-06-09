package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Shows implements ActionListener {

    public static String Name;
    JLabel label;
    JLabel L2;
    JLabel bg;
    int count = 0;
    JTextField tf;
    JFrame frm;

    public Shows(String name) {
        Name = name;
        frm = new JFrame("Series");
        frm.setSize(1600, 900);
        frm.setLocationRelativeTo(null);

        ImageIcon bgimg = new ImageIcon("img.jpg");
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

        JButton back = new JButton("Back");
        back.setBounds(50, 70, 100, 30);
        bg.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Welcome(name);
                frm.dispose();

            }
        });

        label = new JLabel("Series");
        label.setBounds(745, 330, 200, 200);
        label.setForeground(Color.white);
        label.setFont(new Font("MuseoSansRounded100", Font.BOLD, 40));
        bg.add(label);

        tf = new JTextField(15);
        tf.setBounds(675, 480, 250, 30);
        tf.setFont(new Font("Lato", Font.PLAIN, 20));
        tf.addActionListener(this);
        bg.add(tf);

        JButton search = new JButton("Search");
        search.setBounds(750, 540, 100, 40);
        bg.add(search);

        search.addActionListener(this);


    } // constructor

    public void actionPerformed(ActionEvent ae) {
        if (tf.getText().length() == 0)
            JOptionPane.showMessageDialog(null, "Enter a SHOW!");
       else{

            new SDisplay(tf.getText(), Name);
            frm.dispose();
       }

    }

}
