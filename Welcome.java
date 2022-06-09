package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome {

    public static String Name;
    JFrame frm;
    JLabel option;
    JLabel bg;

    public Welcome(String name) {

        Name = name;
        frm = new JFrame("Welcome");
        frm.setSize(1600, 900);
        frm.setLocationRelativeTo(null);

        ImageIcon bgimg = new ImageIcon("black.jpg");
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

                new Login();
                frm.dispose();
            }
        });

        ImageIcon icon = new ImageIcon("movie.jpeg");
        JButton Movie = new JButton(icon);
        Movie.setBounds(475, 200, 300, 500);
        bg.add(Movie);
        Movie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Film(name);
                frm.dispose();
            }
        });

        ImageIcon iconn = new ImageIcon("series2.jpg");
        JButton Tv_show = new JButton(iconn);
        Tv_show.setBounds(825, 200, 300, 500);
        bg.add(Tv_show);
        Tv_show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Shows(name);
                frm.dispose();
            }
        });


    } // constructor

}
