package edu.juniv.cse.user;
import edu.juniv.cse.main.Conn;
import edu.juniv.cse.model.User_choice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login implements ActionListener {

    JFrame f;
    JLabel l1, l2, ll;
    JTextField t1, tt;
    JPasswordField t2;
    JButton b1, b2;
    public login() {

        f = new JFrame("Login");

        f.setBackground(Color.white);
        f.setLayout(null);

        ll = new JLabel("Email");
        ll.setBounds(40, 30, 100, 30);
        f.add(ll);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        f.add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 30, 150, 30);
        f.add(t1);
        t2 = new JPasswordField();
        t2.setBounds(150, 70, 150, 30);
        f.add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("edu/juniv/cse/icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350, 20, 150, 150);
        f.add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);

        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(600, 300);
        f.setLocation(400, 300);

    }

    public void actionPerformed(ActionEvent ae) {

        try {
            Conn c1 = new Conn();
            String mail = t1.getText();
            String pass = t2.getText();
            String q = "select * from login where Email= '" + mail + "' and password='" + pass+ "'";
            ResultSet rs;
            rs = c1.s.executeQuery(q);
            if (rs.next()) {
                f.setVisible(false);
                new User_choice();            }
            else {

                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) {
        new login();
    }
}