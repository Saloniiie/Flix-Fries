package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class SDisplay implements INTERFACE.Info {

    JLabel L1, L2, L3, L4, L5, L6, L7;
    JLabel bg;
    int count = 0;
    int num = 0;
    int count2 = 0;
    String Name, S;

    public void display_movie() {
        L1 = new JLabel("");
        L1.setText(S.toUpperCase());
        L1.setBounds(180, 30, 1600, 52);
        L1.setForeground(new Color(247, 243, 131));
        L1.setFont(new Font("Arial", Font.BOLD, 48));
        bg.add(L1);

        String x = " ";
        int n;

        try (BufferedReader br = new BufferedReader(new FileReader("Series.txt"))) {

            while (x != null && (!(x.equalsIgnoreCase(S)))) {
                x = br.readLine();
            }

            if (x == null) {
                L2 = new JLabel("");
                L2.setText("This series is currently not available in our record :(");
                L2.setBounds(180, 100, 1600, 25);
                L2.setForeground(Color.white);
                L2.setFont(new Font("MuseoSansRounded100", Font.BOLD, 20));
                bg.add(L2);
            }

            else {

                do {
                    x = br.readLine();
                    n = x.length() - 1;
                    if ((x.charAt(n) == '*')) {
                        String y = x.substring(0, n);
                        L2 = new JLabel("");
                        L2.setText(y);
                        L2.setBounds(180, 100 + count, 1600, 25);
                        L2.setForeground(Color.white);
                        L2.setFont(new Font("MuseoSansRounded100", Font.BOLD, 20));
                        bg.add(L2);
                        count += 30;
                    } else {
                        L2 = new JLabel("");
                        L2.setText(x);
                        L2.setBounds(180, 100 + count, 1600, 25);
                        L2.setForeground(Color.white);
                        L2.setFont(new Font("MuseoSansRounded100", Font.BOLD, 20));
                        bg.add(L2);
                        count += 30;
                    }
                } while (x.charAt(n) != '*' && x != null);
            }

        } catch (IOException e) {
            System.out.println("an I/O error occured");
        }

    } // display_movie

    public void display_review() {
        L3 = new JLabel("User's Reviews :");
        L3.setBounds(180, 150 + count, 1600, 25);
        L3.setForeground(Color.pink);
        L3.setFont(new Font("MuseoSansRounded100", Font.BOLD, 30));
        bg.add(L3);

        String m = " ";

        try (BufferedReader ef = new BufferedReader(new FileReader("Series Review.txt"))) {

            do {
                m = ef.readLine();
                if (m != null) {
                    int o = m.indexOf(S.toLowerCase());
                    if (o != -1) {
                        num++;
                        String j = m.substring(o + S.length(), m.length());
                        L4 = new JLabel("");
                        L4.setText(j);
                        L4.setBounds(180, 180 + count + count2, 1600, 25);
                        L4.setForeground(Color.white);
                        L4.setFont(new Font("MuseoSansRounded100", Font.BOLD, 20));
                        bg.add(L4);
                        count2 += 30;
                    }
                }
            } while (m != null);

            if (num == 0) {
                L5 = new JLabel("No reviews have been added till now");
                L5.setBounds(180, 180 + count, 1600, 25);
                L5.setForeground(Color.white);
                L5.setFont(new Font("MuseoSansRounded100", Font.BOLD, 20));
                bg.add(L5);
            }

        } catch (IOException e) {
            System.out.println("an I/O error occured");
        }

    } // display_review

    public void display_rating() {
        String q;
        int rflag = 0;
        float f[] = new float[100];
        float average;
        float sum;
        try (BufferedReader gh = new BufferedReader(new FileReader("ratings-series.txt"))) {
            do {
                q = gh.readLine();
                if (q != null) {
                    int o = q.indexOf(S.toLowerCase());
                    if (o != -1) {

                        String fl = q.substring(o + S.length(), q.length());
                        f[rflag] = Float.parseFloat(fl);
                        rflag++;
                    }

                }
            } while (q != null);

            sum = 0;
            for (int i = 0; i < rflag; i++) {
                sum += f[i];
            }
            average = sum / rflag;

            L6 = new JLabel("AVERAGE USER RATING :");
            L6.setBounds(1040, 30, 800, 40);
            L6.setForeground(Color.pink);
            L6.setFont(new Font("MuseoSansRounded100", Font.BOLD, 30));
            bg.add(L6);

            L7 = new JLabel("");
            L7.setText(String.format("%.1f", average));
            L7.setBounds(1440, 30, 800, 30);
            L7.setForeground(Color.white);
            L7.setFont(new Font("MuseoSansRounded100", Font.BOLD, 40));
            bg.add(L7);

        } catch (IOException e) {
            System.out.println("an I/O error occured");
        }

    } // display_rating

    public SDisplay(String s, String name) {
        S = s;
        Name = name;
        JFrame frm = new JFrame("Sdisplay");
        frm.setSize(1600, 1000);
        frm.setLocationRelativeTo(null);

        ImageIcon bgimg = new ImageIcon("bg1.jpeg");
        Image img = bgimg.getImage();
        Image temp_img = img.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
        bgimg = new ImageIcon(temp_img);
        bg = new JLabel("", bgimg, JLabel.CENTER);
        bg.setBounds(0, 0, 1600, 1000);
        frm.add(bg);

        frm.setLayout(new FlowLayout());
        frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
        frm.setVisible(true);

        JButton exit = new JButton("Exit");
        exit.setBounds(50, 20, 110, 30);
        bg.add(exit);

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);

            }
        });

        JButton back = new JButton("Back");
        back.setBounds(50, 70, 110, 30);
        bg.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new Shows(name);
                frm.dispose();
            }
        });

        JButton addR = new JButton("Add Review");
        addR.setBounds(50, 120, 110, 30);
        bg.add(addR);

        addR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                new SReview(s, name);
                frm.dispose();
            }
        });

        JButton rate = new JButton("Add Rating");
        rate.setBounds(50, 170, 110, 30);
        bg.add(rate);
        rate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new SRating(s, name);
                frm.dispose();
            }
        });

        display_movie();

        display_review();

        display_rating();

    } // constructor
}