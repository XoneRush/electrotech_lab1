import javax.swing.*;
import java.awt.*;

public class GraphicDraw extends JFrame {
    PanelGraphics surface = new PanelGraphics(20);
    public GraphicDraw(double[] X, double[] Y){
        surface.setXarr(X);
        surface.setYarr(Y);
        add(surface);

        setTitle("Graphics");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        setVisible(true);
    }
}
