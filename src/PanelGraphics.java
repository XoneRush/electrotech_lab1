import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class PanelGraphics extends JPanel {
    int width = 500;
    int height = 500;
    int scaling;

    double X[];
    double Y[];

    public PanelGraphics(int scaling){
        this.setPreferredSize(new Dimension(width,height));
        this.scaling = scaling;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        drawGrid(g, scaling);
        drawDiagram(g2d, X, Y, scaling, 500, Color.BLACK);
    }

    public void drawDiagram(Graphics2D g, double[] x, double y[], double scaling, int height, Color color) {
        int startY = height;
        double backCf = height * (scaling-1);
        System.out.println(backCf);
        double[] origY = Arrays.copyOf(y, y.length);

        for(int i=0; i < x.length; i++){
            y[i] = startY - y[i];
            y[i] = scaling * y[i] - backCf;
        }

        g.setColor(color);

        for(int i = 0; i < x.length-1; i++) {
            g.drawLine((int)(scaling * x[i]),(int)y[i], (int)(scaling * x[i+1]), (int)y[i+1]);
            g.drawString("(" + x[i] + "," + origY[i] + ")",(int)(scaling * x[i] + 5),(int)y[i]);
        }
    }

    public void drawGrid(Graphics g, int scaling){
        g.setColor(Color.LIGHT_GRAY);
        //height
        for(int i = 0; i<height/scaling; i++){
            g.drawLine(0, i*scaling, width, i*scaling);
            g.drawLine( i*scaling,0, i*scaling, height);
        }
    }

    public void setXarr(double[] x) {
        X = x;
    }

    public void setYarr(double[] y) {
        Y = y;
    }
}
