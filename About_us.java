package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class About_us {

    JFrame frm;
    JLabel bg;
    JLabel L1;
    JLabel L2;

    public About_us() {

        frm = new JFrame("About_us");
        frm.setSize(1600, 900);
        frm.setLocationRelativeTo(null);

        ImageIcon bgimg = new ImageIcon("im.jpg");
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

        L1 = new JLabel("");
        L1.setText("ABOUT US");
        L1.setBounds(180, 30, 1600, 52);
        L1.setForeground(Color.pink);
        L1.setFont(new Font("Arial", Font.BOLD, 48));
        bg.add(L1);

        String x = " ";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("About.txt"))) {

            do {
                if (x != null) {
                    x = br.readLine();
                    L2 = new JLabel("");
                    L2.setText(x);
                    L2.setBounds(180, 100 + count, 1600, 25);
                    L2.setForeground(Color.white);
                    L2.setFont(new Font("MuseoSansRounded100", Font.BOLD, 20));
                    bg.add(L2);
                    count += 30;
                }

            } while (x != null);

        } catch (IOException e) {
            System.out.println("an I/O error occured");
        }


    } // constructor

}