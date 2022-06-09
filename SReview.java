package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class SReview {
    JLabel L1;
    JLabel bg;
    public static String Name, S;

    public SReview(String s, String name) {
        S = s;
        Name = name;
        JFrame frm = new JFrame("SReview");
        frm.setSize(1600, 900);
        frm.setLocationRelativeTo(null);

        ImageIcon bgimg = new ImageIcon("rating_bg.jpg");
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

                new SDisplay(s, name);
                frm.dispose();
            }
        });

        L1 = new JLabel("");
        L1.setText("ENTER YOUR REVIEW");
        L1.setBounds(740, 170, 1600, 40);
        L1.setForeground(new Color(255, 255, 255));
        L1.setFont(new Font("Arial", Font.BOLD, 48));
        bg.add(L1);

        JTextArea tf = new JTextArea(10, 50);
        tf.setBounds(730, 270, 540, 300);
        tf.setFont(new Font("Lato", Font.PLAIN, 20));
        bg.add(tf);

        JButton add = new JButton("Add");
        add.setBounds(950, 600, 100, 40);
        bg.add(add);

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (tf.getText().length() == 0)
                    JOptionPane.showMessageDialog(null, "Enter a REVIEW!");

                else {

                    try {
                        File file = new File("Series Review.txt");
                        String z = tf.getText();
                        FileWriter rs = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(rs);
                        bw.write("\n");
                        bw.write(s.toLowerCase());
                        bw.write(name);
                        bw.write(" : ");
                        bw.write(z);
                        bw.write("\n");
                        bw.close();
                    } catch (IOException e) {
                        System.out.println("error occured");
                    }

                    new SDisplay(s, name);
                    frm.dispose();

                }

            }
        });


    } // constructor

}
