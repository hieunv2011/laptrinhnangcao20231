/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app004_drawing;

/*

  @author tinhphamm1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame
        implements ActionListener,MouseMotionListener,MouseListener
   {
    public JLabel lb1;
    public JTextField txt1;
    public JTextField txt2;
    public JPanel p1;
    public JButton btn1;
    public int x0,y0,x1,y1;
    public Color c;
    public MyWindow()
    {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        lb1=new JLabel("Enter your name:");
        lb1.setBounds(10, 10, 100, 30);
        txt1=new JTextField();
        txt1.setBounds(120, 10, 150, 30);
        txt2=new JTextField();
        txt2.setBounds(280, 10, 150, 30);
        p1=new JPanel();
        p1.setBackground(Color.black);
        p1.setBounds(10, 100, 500, 400);
        p1.addMouseListener(this);
        p1.addMouseMotionListener(this);
        this.add(p1);
        btn1=new JButton("Say Hello");
        btn1.setBounds(90, 50, 100, 30);
        this.add(lb1);
        this.add(txt1);
        this.add(txt2);
        this.add(btn1);
        btn1.addActionListener(this);
        this.setVisible(true);
        c=Color.GREEN;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1)
        {
            txt2.setText("hello "+txt1.getText());
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x1=e.getX();
        y1=e.getY();
        Graphics2D g=(Graphics2D)p1.getGraphics();
        g.setStroke(new BasicStroke(5.0f));
        g.setColor(c);
        g.drawLine(x0, y0, x1, y1);
        x0=x1;
        y0=y1;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x0=e.getX();
        y0=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
