package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Created by Maksym on 2015-07-20.
 */
public class Window extends JFrame implements ActionListener {

    public Physics p = new Physics();
    JButton activator, next1,next2, clear;
    JLabel jlSpeed, jlAngle, jdlXmax, jdlYmax, jlMS;
    JTextField jfSpeed, jfAngle;
    JTextPane explain, equation;
    double g = 9.8f, Speed, Angle;



    public void Window() throws Exception {
        setTitle("Symulator rzutu ukośnego");
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
        getContentPane().add(jlAngle);
        getContentPane().add(jlMS);
        getContentPane().add(jfSpeed);
        getContentPane().add(jfAngle);
        getContentPane().add(clear);
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
        explain.setText("<html>"+"  "+"</html>");

        equation = new JTextPane();
        equation.setBounds(20, 20, 960, 550);
        equation.setVisible(true);
        equation.setEditable(false);
    }

    public void Labels() {
        jlSpeed= new JLabel("Prędkość początkowa");
        jlSpeed.setBounds(20, 100, 200, 25);
        jlSpeed.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
        jlSpeed.setToolTipText("Wprowadź Vo");
        jlSpeed.setVisible(true);

        jlAngle = new JLabel("Kąt (0-90)");
        jlAngle.setBounds(20, 200, 200, 25);
        jlAngle.setFont(new Font("TimesNewRoman", Font.BOLD, 15));
        jlAngle.setToolTipText("Wprowadź kąt początkowy");
        jlAngle.setVisible(true);

        jlMS = new JLabel("[m/s]");
        jlMS.setBounds(175,140,35,25);
        jlMS.setFont(new Font("TimesNewRoman", Font.BOLD, 12));
        jlMS.setVisible(true);


       /* jlMaxHeight = new JLabel("");
        jlMaxHeight.setBounds(10, 500, 110, 25);
        jlMaxHeight.setFont(new Font("TimesNewRoman", Font.BOLD, 10));
        jlMaxHeight.setVisible(true);*/
    }

        public void TextFields() {
            jfSpeed = new JTextField("");
            jfSpeed.setBounds(20, 140, 150, 25);
            jfSpeed.setVisible(true);

            jfAngle = new JTextField("");
            jfAngle.setBounds(20, 240, 150, 25);
            jfAngle.setVisible(true);
        }

        public void Buttons(){
            activator = new JButton("Symuluj");
            activator.setBounds(20,280,100,50);
            activator.setVisible(true);
            activator.addActionListener(this);

            next1 = new JButton("Dalej");
            next1.setBounds(420,600,100,50);
            next1.setVisible(true);
            next1.addActionListener(this);

            next2 = new JButton("Dalej");
            next2.setBounds(420,600,100,50);
            next2.setVisible(true);
            next2.addActionListener(this);

            clear = new JButton("Wyczyść");
            clear.setFont(new Font("TimesNewRoman", Font.BOLD, 10));
            clear.setBounds(20,340,100,50);
            clear.setVisible(true);
            clear.addActionListener(this);

        }
        public void draw(){

            double mathPowS = Math.pow(Speed,2); // kwadrat prędkości początkowej
            double mathTanA=  Math.tan(Angle*Math.PI / 180);// tangens kąta
            double mathCosPowA= Math.pow(Math.cos(Angle*Math.PI / 180), 2); //kosinus kwadrat kąta
            double Ymax =  ((Math.pow((Speed*Math.sin(Angle*Math.PI/180)),2))/(2*g)); //wysokość maksymalna
            double Xmax =   (2*mathPowS*Math.sin(Angle*Math.PI / 180)*Math.cos(Angle*Math.PI / 180))/(g); //zasięg rzutu
            /*System.out.println("mathPowS: " + mathPowS); //Testowanie wartości
            System.out.println("mathTanA: " + mathTanA);
            System.out.println("mathCosPowA: " + mathCosPowA);
            System.out.println("Moje Xmax: " + Xmax);
            System.out.println("Moje Ymax: " + Ymax);*/
            int Xposition = (int) Xmax, Yposition = (int) Ymax;
            String Xlab = String.valueOf(Xposition), Ylab = String.valueOf(Yposition) ;
            int indexY = (int) ((Ymax/580)+1);
            int index = (int) ((Xmax/739)+1);
            System.out.println("Index: "+ index);
            int Xmax2 = (int) Xmax;
            jdlXmax = new JLabel(Xlab + " m");
            p.add(jdlXmax);
            jdlXmax.setBounds(Xposition/index, 580/indexY, 40, 15);
            jdlXmax.setVisible(true);

            jdlYmax = new JLabel(Ylab + " m");
            p.add(jdlYmax);
            jdlYmax.setBounds((Xmax2 / 2)/index-5, (580 - Yposition)/indexY, 50, 20);
            jdlYmax.setVisible(true);

           // jlMaxHeight.setText("Max wysokość: " + Ylab);

            for(int X=0; X <Xmax2;X++){
                double mathPowX = Math.pow(X,2);
                int Y = (int) ((X * mathTanA) - ((g / (2 * mathPowS * mathCosPowA)) * mathPowX));
                //System.out.println(Y);
                p.getGraphics().drawLine(X / index, (600 - Y), X / index, (600 - Y));

            }
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object bSource = e.getSource();
        if(bSource == activator){
            Angle = Double.parseDouble(jfAngle.getText());
            Speed = Double.parseDouble(jfSpeed.getText());

            p.getGraphics().drawLine(1, 1, 1, 600);
            p.getGraphics().drawLine(1, 599, 749, 599);
            draw();
        }
        else if(bSource == clear){
            p.remove(jdlXmax);
            p.remove(jdlYmax);
            p.repaint();

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





