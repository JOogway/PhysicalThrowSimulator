package com.company;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.math.*;


/**
 * Created by Maksym on 2015-07-20.
 */
public class Window extends JFrame implements ActionListener {

    public Physics p = new Physics();
    JButton activator, next1,next2;
    JLabel jlSpeed, jlHeight, jlMaxHeight, jlAngle;
    JTextField jfSpeed, jfHeight, jfAngle;
    JTextPane explain, equation;
    double g = 9.8f,X, MaxHeight,StartHeight = 0, Speed, Angle;


    public void Window() throws Exception {
        setSize(1000,700);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        Labels();
        TextFields();
        p.PhysicsInit(getGraphics());
        Buttons();
        TextPane();
        ExplanationInit();
        repaint();

    }
    public void ChartInit(){
        getContentPane().add(activator);
        getContentPane().add(jlSpeed);
        getContentPane().add(jlMaxHeight);
        getContentPane().add(jlAngle);
        getContentPane().add(jfSpeed);
        getContentPane().add(jfAngle);
        getContentPane().add(p);
        repaint();
    }
    public void ExplanationInit(){
        getContentPane().add(explain);
        getContentPane().add(next1);
        repaint();



    }
    public void EquationsInit(){
        getContentPane().add(equation);
        getContentPane().add(next2);
        repaint();
    }
    public void TextPane(){
        explain = new JTextPane();
        explain.setBounds(20, 20, 960, 550);
        explain.setVisible(true);
        explain.setEditable(false);

        equation = new JTextPane();
        equation.setBounds(20, 20, 960, 550);
        equation.setVisible(true);
        equation.setEditable(false);
    }

    public void Labels() {
        jlSpeed= new JLabel("Prędkość początkowa");
        jlSpeed.setBounds(20, 100, 200, 25);
        jlSpeed.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        jlSpeed.setToolTipText("Wprowadź Vo");
        jlSpeed.setVisible(true);

        jlAngle = new JLabel("Kąt");
        jlAngle.setBounds(20,200,200,25);
        jlAngle.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        jlAngle.setToolTipText("Wprowadź kąt początkowy");
        jlAngle.setVisible(true);

        jlMaxHeight = new JLabel("Max wysokość");
        jlMaxHeight.setBounds(20, 500, 200, 25);
        jlMaxHeight.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
        jlMaxHeight.setVisible(true);


    }
        public void TextFields() {
            jfSpeed = new JTextField("0");
            jfSpeed.setBounds(20, 140, 150, 25);
            jfSpeed.setVisible(true);

            jfAngle = new JTextField("0");
            jfAngle.setBounds(20, 240, 150, 25);
            jfAngle.setVisible(true);
        }

        public void Buttons(){
            activator = new JButton("Symuluj");
            activator.setBounds(20,380,100,50);
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
        public void draw(){
            double mathPowS = Math.pow(Speed,2);
            double mathPowG = (mathPowS/g);
            double mathSin =  Math.sin(2 * Angle);
            double mathTanA=  Math.tan(Angle);
            double mathCosPowA= Math.pow(Math.cos(Angle), 2);
            double Xmax =  ( mathPowG * mathSin);
            System.out.println("Moje Xmax: " + Xmax);
            System.out.println("Moje mathSin: ");
            //jfAngle.setText(String.valueOf(Y))
            int Xmax2 = (int) Xmax;
            for(int X=0; X <Xmax2;X++){
                double mathPowX = Math.pow(X,2);
                int Y = (int) ((X * mathTanA) - ((g / (2 * mathPowS * mathCosPowA)) * mathPowX));
                System.out.println(Y);
                p.getGraphics().drawLine(X, (600-Y), X, (600-Y));
            }
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object bSource = e.getSource();
        if(bSource == activator){
            Angle = Integer.parseInt(jfAngle.getText());
            Speed = Integer.parseInt(jfSpeed.getText());
            p.getGraphics().drawLine(1, 1, 1, 600);
            p.getGraphics().drawLine(1, 599, 749, 599);
            draw();
        }
        else if(bSource == next1){
            remove(next1);
            remove(explain);
            repaint();
            EquationsInit();
        }
        else if (bSource == next2) {
            remove(next2);
            remove(equation);
            repaint();
            ChartInit();
        }
    }



}
 class Physics extends JPanel {

    public void PhysicsInit(Graphics g) {
        FlowLayout fl = new FlowLayout(0,50,40);
        setLayout(fl);
        setBounds(220, 50, 750, 600);
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        g.setColor(Color.BLACK);
    }
}





