package edu.juniv.cse.view;


import edu.juniv.cse.auth.Auth;
import edu.juniv.cse.main.Conn;
import edu.juniv.cse.model.User_choice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

public class Insert_user_id implements ActionListener{
    private JFrame f;
    private JLabel id,id1;
    private JButton b1,b2;
    Auth auth = new Auth();
    private JTextField t1;
    public Insert_user_id()
    {
        f=new JFrame("user details");
        f.setVisible(true);
        f.setSize(595,642);
        f.setLocation(450,200);
        f.setBackground(Color.white);
        f.setLayout(null);
        id=new JLabel();
        id.setBounds(0,0,595,642);
        id.setLayout(null);
        int i=20;
        id1=new JLabel("User Id");
        id1.setBounds(100,i+30,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id.add(id1);
        t1=new JTextField();
        t1.setBounds(200,i+30,100,30);
        id.add(t1);
        i+=100;
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,i,100,30);
        b1.addActionListener(this);
        id.add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,i,100,30);
        b2.addActionListener(this);
        id.add(b2);
        f.add(id);
          f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
        i+=30;
        try{
            Conn con=new Conn();
            String q="select*from user";

            ResultSet rs= con.s.executeQuery(q);

            f.setVisible(true);
            ArrayList<String>list=new ArrayList<>();
            while(rs.next())
            {
                list.add(rs.getString("user_id"));
            }
            Iterator itr=list.iterator();
            while(itr.hasNext())
            {
                String Idd= (String) itr.next();
                id=new JLabel(Idd);
                id.setBounds(100,i,100,30);
                f.add(id);
                i+=35;
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1)
        {
            auth.UserID=t1.getText();
            f.setVisible(false);

            new User_info();
        }
        if(ae.getSource()==b2)
        {
            f.setVisible(false);
            new User_choice();
        }

    }
}
