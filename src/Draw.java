import Suites.Suite;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Draw extends JFrame {

    public Draw(ArrayList<ArrayList<Double>>cv, double maxNorme, double moyDiv,double maxDiv){
        this.setTitle("Ensemble de Mandelbrot");
        this.setSize(cv.size(),cv.get(0).size());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.out.println(moyDiv);

        JPanel p = new JPanel(){
            public void paintComponent (Graphics g){
                BufferedImage img = new BufferedImage(cv.size(),cv.get(0).size(),BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = img.createGraphics();
                for(int i=0;i<cv.size();i++){
                    for (int j=0; j<cv.get(0).size();j++){
                        Double n = cv.get(i).get(j);
                        if(n<0){
                            int c = (int)(-n/maxNorme * 255);
                            g2d.setColor(new Color(0,c,255-c));
                        }
                        else {
                            int r = Math.min((int)(n/moyDiv *255),255);
                            int m = Math.min((int)(n/(maxDiv/(Suite.ITER_BORNEE/50))*255),255);
                            g2d.setColor(new Color(r,m,255-r));
                        }
                        g2d.drawRect(i,cv.get(0).size()-1-j,1,1);
                    }
                }
                g2d.dispose();
                g.drawImage(img,0,0,Color.WHITE,null);
            }
        };
        this.setContentPane(p);
        this.setVisible(true);
    }
}
