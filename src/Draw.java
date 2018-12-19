import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Draw extends JFrame {

    public Draw(ArrayList<ArrayList<Boolean>>cv){
        this.setTitle("Ensemble de Mandelbrot");
        this.setSize(cv.size(),cv.get(0).size());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel p = new JPanel(){
            public void paintComponent (Graphics g){
                BufferedImage img = new BufferedImage(cv.size(),cv.get(0).size(),BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = img.createGraphics();
                for(int i=0;i<cv.size();i++){
                    for (int j=0; j<cv.get(0).size();j++){
                        if(cv.get(i).get(j)){
                            g2d.setColor(Color.BLACK);
                        }
                        else {
                            g2d.setColor(Color.GREEN);
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
