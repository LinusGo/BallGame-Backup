/**
 * @author LinusW
 * @create 2020-12-12-4:42 PM
 */
import java.awt.Color;

public class Shrink extends Basic{
    public double initR;
    // constructor
    public Shrink(double r, Color c, String ballType) {
        super(r,c,ballType);
        initR = r;
    }

    public int getScore() {
        return 20;
    }

    public void reset() {
        rx = 0.0;
        ry = 0.0;
        vx = StdRandom.uniform(-0.01, 0.01);
        vy = StdRandom.uniform(-0.01, 0.01);
        radius *= (0.66);
        if (radius <= initR * (0.25)){
            radius = initR;
        }
    }
    
}
