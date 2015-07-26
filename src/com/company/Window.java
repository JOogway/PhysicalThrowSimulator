package com.company;

import com.company.Physics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Maksym on 2015-07-20.
 */
public class Window extends JFrame implements ActionListener {


    public Physics p = new Physics();
    JButton activator, next1,next2;
    JLabel jlForce, jlHeight, jlMaxHeight, jlAngle;
    JTextField jfForce, jfHeight, jfAngle;
    Color colorToUse;
    int X1,X2,Y1,Y2,MaxHeight,i,StartHeight = 0,Force,Angle;

    public void Window() throws Exception {

        setSize(1000,700);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //ChartInit();
        Labels();
        TextFields();
        p.Physics(getGraphics());
        Buttons();
        ExplanationInit();
        repaint();

    }
    public void ChartInit(){
        getContentPane().add(activator);
        getContentPane().add(jlForce);
        getContentPane().add(jlHeight);
        getContentPane().add(jlMaxHeight);
        getContentPane().add(jlAngle);
        getContentPane().add(jfForce);
        getContentPane().add(jfHeight);
        getContentPane().add(jfAngle);
        getContentPane().add(p);
        repaint();
    }
    public void ExplanationInit(){
       getContentPane().add(next1);
        repaint();



    }
    public void EquationsInit(){
        getContentPane().add(next2);
        repaint();
    }

    public void Labels() {
        jlForce = new JLabel("Siła");
        jlForce.setBounds(20, 100, 200, 25);
        jlForce.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        jlForce.setToolTipText("Wprowadź Vo");
        jlForce.setVisible(true);


        jlHeight = new JLabel("Wysokość pocz.");
        jlHeight.setBounds(20, 200, 200, 25);
        jlHeight.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        jlHeight.setToolTipText("Domyślnie zero");
        jlHeight.setVisible(true);

        jlAngle = new JLabel("Kąt");
        jlAngle.setBounds(20,300,200,25);
        jlAngle.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        jlAngle.setToolTipText("Wprowadź kąt początkowy");
        jlAngle.setVisible(true);

        jlMaxHeight = new JLabel("Max wysokość");
        jlMaxHeight.setBounds(20, 500, 200, 25);
        jlMaxHeight.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        jlMaxHeight.setVisible(true);


    }
        public void TextFields() {
            jfForce = new JTextField("0");
            jfForce.setBounds(20, 140, 150, 25);
            jfForce.setVisible(true);

            jfHeight = new JTextField("0");
            jfHeight.setBounds(20, 240, 150, 25);
            jfHeight.setVisible(true);

            jfAngle = new JTextField("0");
            jfAngle.setBounds(20,340,150,25);
            jfAngle.setVisible(true);
        }

        public void Buttons(){
            activator = new JButton("Symuluj");
            activator.setBounds(20,450,100,50);
            activator.setVisible(true);
            activator.addActionListener(this);

            next1 = new JButton("Dalej");
            next1.setBounds(400,600,100,50);
            next1.setVisible(true);
            next1.addActionListener(this);

            next2 = new JButton("Dalej");
            next2.setBounds(400,600,100,50);
            next2.setVisible(true);
            next2.addActionListener(this);

        }

      /*  public void paint(Graphics g) {
                g.drawLine(X1, Y1, X2, Y2);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        Object bSource = e.getSource();
        if(bSource == activator){
            Angle = Integer.parseInt(jfAngle.getText());
            Force = Integer.parseInt(jlForce.getText());
            StartHeight = Integer.parseInt(jlHeight.getText());

            for(X1=100;X1>0;X1--){
                X2=X1;
            for(Y1=100; Y1>0; Y1--) {
                Y2=Y1;
                p.getGraphics().drawLine(X1,Y1,X2,Y2);
            }
            }
        }else if(bSource == next1){
            remove(next1);
            repaint();
            EquationsInit();
        }
        else if (bSource == next2) {
            remove(next2);
            repaint();
            ChartInit();
        }
    }



}
 class Physics extends JPanel {

    public void Physics(Graphics g) {
        FlowLayout fl = new FlowLayout(0,50,40);
        setLayout(fl);
        setBounds(220, 50, 750, 600);
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        g.setColor(Color.WHITE);

        setAlignmentX(23);


    }
}





