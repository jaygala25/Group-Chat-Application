package client;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class Client extends JFrame implements ActionListener
{
    JLabel l;
    JButton b;
    JTextField t;
    
    public Client()
    {
        setLayout(null);
        l=new JLabel("Name");
        t=new JTextField();
        b=new JButton("Sign In");
        add(l);
        add(t);
        add(b);
        l.setBounds(200,100,40,25);
        t.setBounds(250,100,150,25);
        b.setBounds(250,175,80,25);
        b.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            String in=t.getText();
            this.dispose();
            c f=new c(in);
            f.setVisible(true);
            f.setTitle(in+"'s Chat WIndow");
        }
    }
    
    public static void main(String[] args) 
    {
        Client a=new Client();
        a.setSize(600,400);
        a.setVisible(true);
        a.setTitle("Chat Server");
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}