package edu.juniv.cse.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.juniv.cse.repository.Insert_hotel;
import edu.juniv.cse.repository.Room_insert;

public class Hotel_choice  implements ActionListener {

    private JFrame f;
    private  JButton b1,b2,b3;

    public Hotel_choice(){
        f=new JFrame("Choice");
        f.setBackground(Color.white);
        f.setLayout(null);

        JLabel l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("edu/juniv/cse/icons/details.jpg"));
        l1.setIcon(i1);
        f.add(l1);

        b1=new JButton("Hotel");
        b1.setBounds(420,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("Room");
        b2.setBounds(530,80,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Cancel");
        b3.setBounds(420,140,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new Insert_hotel();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new Room_insert();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new Insert_choice();
        }
    }

}

