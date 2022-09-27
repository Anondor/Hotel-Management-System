package edu.juniv.cse.model;
import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;

public class Front_Page implements ActionListener{
    JFrame f;
    JLabel id;
    JButton b;

    public Front_Page(){

        f=new JFrame("Front");
        f.setBackground(Color.red);
        f.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("edu/juniv/cse/icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);

        l1.setBounds(0,150,1100,500);
        f.add(l1);


        b = new JButton("CLICK HERE TO CONTINUE");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);


        b.setBounds(400,500,300,70);
        b.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1100,700);
        id.setLayout(null);



        JLabel lid=new JLabel("Hotel Management System");
        lid.setBounds(80,30,1050,80);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(Color.red);
        id.add(lid);

        id.add(b);
        f.add(id);


        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(1100,700);
        f.setLocation(200,100);

        while(true){
            lid.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            f.setVisible(false);
            new Choice();
        }
    }

}