package edu.juniv.cse.view;

import edu.juniv.cse.auth.Auth;
import edu.juniv.cse.main.Conn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

public class Customer_info implements ActionListener {
    private JFrame f;
    private JLabel id, id1, id8;
    private JButton b1, b2;

    public Customer_info() {

        f = new JFrame("Customer Information");
        f.setVisible(true);
        f.setSize(55, 642);
        f.setLocation(450, 200);
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        f.setSize(900, 700);
        f.setLocation(400, 150);

        int i = 30;
        id = new JLabel("Customer Details");
        id.setBounds(300, i + 30, 250, 30);

        f.add(id);
        id.setFont(new Font("serif", Font.BOLD, 25));
        f.add(id);

        i += 100;
        Auth auth = new Auth();
        try {
            Conn con = new Conn();

            String q = "select*from customer where '" + auth.UserID + "'=cus_id";
            ResultSet rs = con.s.executeQuery(q);
            f.setVisible(true);
            ArrayList<String> list = new ArrayList<String>();
            String nam;
            while (rs.next()) {
                nam = "Name: " + rs.getString("Fname") + " " + rs.getString("Lname");
                list.add(nam);
                nam = "Email: " + rs.getString("Email");
                list.add(nam);
                nam = "Address: " + rs.getString("Address");
                list.add(nam);
                nam = "Mobile: " + rs.getString("Mobile");
                list.add(nam);
            }
            Iterator itr = list.iterator();
            while (itr.hasNext()) {
                String Idd = (String) itr.next();
                id = new JLabel(Idd);
                id.setBounds(200, i, 300, 40);
                f.add(id);
                i += 40;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void actionPerformed(ActionEvent ae) {

    }
}
