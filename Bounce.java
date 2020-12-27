import java.awt.*;

/**
 * @author LinusW
 * @create 2020-12-13-8:20 PM
 */
public class Bounce extends Basic{
    private int numBounce;
    public Bounce(double r, Color c, String ballType) {
        super(r, c, ballType);
        numBounce = 0;
    }

    public int getScore() {
        return 15;
    }

    public void move() {
        if(numBounce > 3){
            isOut = true;
            return;
        }

        if ((Math.abs(rx) > 1.0)) {
            vx *= -1;
            numBounce++;
        }
        if ( (Math.abs(ry) > 1.0)) {
            vy *= -1;
            numBounce++;
        }
        rx = rx + vx;
        ry = ry + vy;
    }

}
