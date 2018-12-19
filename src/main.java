import Suites.Complexe;
import Suites.SuiteMandelbrot;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class main {

    public static void main(String []args) {
        SuiteMandelbrot sm = new SuiteMandelbrot(new Complexe(0.3,0.5));
        double px = 500.0;
        double py = 500.0;
        ArrayList<ArrayList<Boolean>> mdbspx = new ArrayList<ArrayList<Boolean>>();
        JFrame loadF = new JFrame();
        loadF.setTitle("Calculs");
        loadF.setSize(500,100);
        JPanel p = new JPanel();
        GridLayout layout = new GridLayout();
        p.setLayout(layout);
        JLabel label = new JLabel();
        p.add(label);
        loadF.setContentPane(p);
        loadF.setVisible(true);
        int m=0,n=0;
        mdbspx.add(new ArrayList<Boolean>());
        for(double r=-1.5;r<0.75;r+=1/px){
            if(mdbspx.size()<=m){
                mdbspx.add(new ArrayList<Boolean>());
            }
            for(double i=-1.25;i<1;i+=1/py){
                label.setText(sm.c.toString());
                sm.c = new Complexe(r,i);
                mdbspx.get(m).add(sm.bornee());
                loadF.repaint();
                n++;
            }
            m++;
        }
        new Draw(mdbspx);
    }
}
