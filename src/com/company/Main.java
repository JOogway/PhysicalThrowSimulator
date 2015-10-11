package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) throws Exception{
        Window w = new Window();
        w.Window();
    }
}

    class Window extends JFrame implements ActionListener {
        private JLabel equationLabel;
        public Physics p = new Physics();
        JButton activator, next1, next2, clear;
        JLabel jlSpeed, jlAngle, jdlXmax, jdlYmax, jlMS;
        JTextField jfSpeed, jfAngle;
        JTextPane explain;
        double g = 9.8f, Speed, Angle;


        public void Window() throws Exception {
            setTitle("Symulator rzutu ukośnego");
            setSize(1000, 700);
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

        public void ChartInit() {
            setLayout(null);
            setSize(1000, 700);
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

        public void ExplanationInit() {
            getContentPane().add(explain);
            getContentPane().add(next1);
            repaint();
        }

        public void EquationsInit() {
            setLayout(new FlowLayout());
            ImageIcon equation = new ImageIcon((getClass().getResource("equations.jpg")));
            equationLabel = new JLabel(equation);
            equationLabel.setVisible(true);
            getContentPane().add(equationLabel);
            getContentPane().add(next2);
            pack();
            repaint();
        }

        public void TextPane() {
            explain = new JTextPane();
            explain.setBounds(20, 20, 960, 550);
            explain.setVisible(true);
            explain.setEditable(false);
            explain.setContentType("text/html");
            explain.setText("<html>" + "<font size=\"6\"><p><b>Rzut ukośny</b></p> &ndash; ruch w jednorodnym polu grawitacyjnym z <b>prędkością początkową</b> o kierunku ukośnym do kierunku pola." +
                    "Ruch ten odpowiada ruchowi ciała rzuconego pod <b>kątem</b> do poziomu. </p> " +
                    "<p>Rzut ukośny w przypadku braku oporów ośrodka można rozważać jako ruch składający się z rzutu pionowego w górę oraz ruchu jednostajnego prostoliniowego. " +
                    "Można zauważyć że rzut będzie miał największy zasięg gdy wektor wypadkowy będzie wynosił 45 stopni." +
                    "<p>Dzieje się tak przez to że współczynnik rzutu tangens kąta 45 stopni osiąga wtedy swoją maksymalną wartość czyli 1." +
                    "Natomiast największą wysokość osiąga się przy bezpośrednim rzucie pionowym w górę. Wówczas kąt wynosi 90 stopni gdzie tangens nie ma wartości i położenie ciała po rzucie nie zmienia się </p> <br/>");

        }

        public void Labels() {
            jlSpeed = new JLabel("Prędkość początkowa");
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
            jlMS.setBounds(175, 140, 35, 25);
            jlMS.setFont(new Font("TimesNewRoman", Font.BOLD, 12));
            jlMS.setVisible(true);

        }

        public void TextFields() {
            jfSpeed = new JTextField("");
            jfSpeed.setBounds(20, 140, 150, 25);
            jfSpeed.setVisible(true);

            jfAngle = new JTextField("");
            jfAngle.setBounds(20, 240, 150, 25);
            jfAngle.setVisible(true);
        }

        public void Buttons() {
            activator = new JButton("Symuluj");
            activator.setBounds(20, 280, 100, 50);
            activator.setVisible(true);
            activator.addActionListener(this);

            next1 = new JButton("Dalej");
            next1.setBounds(420, 600, 100, 50);
            next1.setVisible(true);
            next1.addActionListener(this);

            next2 = new JButton("Dalej");
            next2.setBounds(420, 600, 100, 50);
            next2.setVisible(true);
            next2.addActionListener(this);

            clear = new JButton("Wyczyść");
            clear.setFont(new Font("TimesNewRoman", Font.BOLD, 10));
            clear.setBounds(20, 340, 100, 50);
            clear.setVisible(true);
            clear.addActionListener(this);

        }

        public void draw() {

            Angle = Double.parseDouble(jfAngle.getText());
            Speed = Double.parseDouble(jfSpeed.getText());

            double mathPowS = Math.pow(Speed, 2); // kwadrat prędkości początkowej
            double mathTanA = Math.tan(Angle * Math.PI / 180);// tangens kąta
            double mathCosPowA = Math.pow(Math.cos(Angle * Math.PI / 180), 2); //kosinus kwadrat kąta
            double Ymax = ((Math.pow((Speed * Math.sin(Angle * Math.PI / 180)), 2)) / (2 * g)); //wysokość maksymalna
            double Xmax = (2 * mathPowS * Math.sin(Angle * Math.PI / 180) * Math.cos(Angle * Math.PI / 180)) / (g); //zasięg rzutu
            int Xposition = (int) Xmax, Yposition = (int) Ymax;
            int indexY = (int) ((Ymax / 580) + 1);
            int index = (int) ((Xmax / 700) + 1);
            int Xmax2 = (int) Xmax;

            String Xpos = String.valueOf(Xposition), Ypos = String.valueOf((Yposition));

            p.getGraphics().drawLine(1, 1, 1, 600);

            for(int i = 1; i<60; i+=5){
                p.getGraphics().drawLine(1,10*i,3,10*i);
                String step =  Integer.toString(((600 - i * 10)*indexY)+10*indexY);
                p.getGraphics().drawString(step,3, 10*i);
            }
            p.getGraphics().drawLine(1, 599, 749, 599);
            for(int i = 1; i<80; i+=5){
                p.getGraphics().drawLine((10*i)-20,600,(10*i)-20,597);
                String step2 =  Integer.toString(((i*10)*index)-10*index);
                p.getGraphics().drawString(step2,(10*i)-20, 595);
            }

            jdlXmax = new JLabel(Xpos + " m");

            jdlXmax.setBounds(Xposition / index, 580 / indexY, 40, 15);

            p.getGraphics().drawString(Xpos,Xposition/index,580/indexY);
            jdlYmax = new JLabel(Ypos + " m");

            jdlYmax.setBounds((Xmax2 / 2) / index - 5, (580 - Yposition) / indexY, 50, 20);
            p.getGraphics().drawString(Ypos,Xmax2/(2*index),(590 - Yposition*indexY) );


            for (int X = 0; X < Xmax2; X++) {
                double mathPowX = Math.pow(X, 2);
                int Y = (int) ((X * mathTanA) - ((g / (2 * mathPowS * mathCosPowA)) * mathPowX));
                p.getGraphics().drawLine(X / index, (600 - Y), X / index, (600 - Y));
            }
        }



        @Override
        public void actionPerformed(ActionEvent e) {
            Object bSource = e.getSource();
            if (bSource == activator) {
                draw();
            } else if (bSource == clear) {
                p.repaint();

            } else if (bSource == next1) {
                remove(next1);
                remove(explain);
                EquationsInit();

                repaint();
            } else if (bSource == next2) {
                remove(next2);
                remove(equationLabel);
                ChartInit();
                repaint();

            }
        }


    }

    class Physics extends JPanel {

        public void PhysicsInit(Graphics g) {
            FlowLayout fl = new FlowLayout(0, 50, 40);
            setLayout(fl);
            setBounds(220, 50, 750, 600);
            setBackground(Color.LIGHT_GRAY);
            setVisible(true);
            g.setColor(Color.BLACK);
        }
    }



