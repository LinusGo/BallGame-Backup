/******************************************************************************
 *  Compilation:  javac BallGame.java
 *  Execution:    java BallGame n
 *  Dependencies: Basic.java StdDraw.java
 *
 *  Creates a Basic ball and animates it
 *
 *  Part of the animation code is adapted from Computer Science:   An Interdisciplinary Approach Book
 *
 *  Run the skeleton code with arguments : 1  basic  0.08
 *******************************************************************************/

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class BallGame {

    public static void main(String[] args) {

        // number of bouncing balls
        int numBalls = 0;
        try {
            numBalls = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.print("Invalid program argument! - java <num> <type> <radius>\n");

        }
        //ball types
        String[] ballTypes = new String[numBalls];
        //sizes of balls
        double[] ballSizes = new double[numBalls];

        try {
            //retrieve ball types
            int index = 1;
            for (int i = 0; i < numBalls; i++) {
                ballTypes[i] = args[index];
                index = index + 2;
            }
        } catch (Exception e) {
            System.out.print("Invalid program argument! - java <num> <type> <radius>\n");
        }

        try {
            //retrieve ball sizes
            int index = 2;
            for (int i = 0; i < numBalls; i++) {
                ballSizes[i] = Double.parseDouble(args[index]);
                index = index + 2;
            }
        } catch (Exception e) {
            System.out.print("Invalid program argument! - java <num> <type> <radius>\n");
        }

        //TO DO: create a Player object and initialize the player game stats.
        Player player = new Player(0, 0, "");

        //number of active balls
        int numBallsinGame = 0;
        StdDraw.enableDoubleBuffering();

        StdDraw.setCanvasSize(800, 800);
        // set boundary to box with coordinates between -1 and +1
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        // create colored balls 
        //TO DO: Create "numBalls" balls (of types given in "ballTypes" with sizes given in "ballSizes") and store them in an Arraylist
        ArrayList<Basic> balls = new ArrayList<>(numBalls);
        for (int i = 0; i < numBalls; i++) {
            switch (ballTypes[i]) {
                case "basic":
                    Basic basic = new Basic(ballSizes[i], Color.RED, ballTypes[i]);
                    balls.add(basic);
                    break;
                case "shrink":
                    Shrink shrink = new Shrink(ballSizes[i], Color.GREEN, ballTypes[i]);
                    balls.add(shrink);
                    break;
                case "bounce":
                    Bounce bounce = new Bounce(ballSizes[i], Color.BLUE, ballTypes[i]);
                    balls.add(bounce);
                    break;
                case "split":
                    Splitl split = new Splitl(ballSizes[i], Color.YELLOW, ballTypes[i]);
                    balls.add(split);
                    break;
            }

        }


        //TO DO: initialize the numBallsinGame
        numBallsinGame = balls.size();

        // do the animation loop
        StdDraw.enableDoubleBuffering();
        while (numBallsinGame > 0) {

            // TODO: move all balls
            for (Basic ball: balls
                 ) {
                ball.move();
            }

            //Check if the mouse is clicked
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                //TODO: check whether a ball is hit. Check each ball.
                for (int i = 0; i < numBallsinGame;i++){
                    Basic ball = balls.get(i);
                    if (balls.get(i).isHit(x, y)){
                        if(balls.get(i) instanceof Splitl){
                            Basic splitl = new Splitl(ball.getRadius(),ball.getColor(),ball.getBallType());
                            balls.add(splitl);
                        }
                        balls.get(i).reset();
                        player.hits();
                        //TO DO: Update player statistics
                        player.setScore(balls.get(i).getScore());
                    }
                }
            }

            numBallsinGame = 0;
            // draw the n balls
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);

            //TO DO: check each ball and see if they are still visible. numBallsinGame should hold the number of visible balls in the game.
            for (Basic ball: balls
                 ) {
                if (!ball.isOut) {
                    ball.draw();
                    numBallsinGame++;
                }
            }
            //Print the game progress
            StdDraw.setPenColor(StdDraw.YELLOW);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            StdDraw.text(-0.65, 0.90, "Number of balls in game: " + String.valueOf(numBallsinGame));
            //TO DO: print the rest of the player statistics
            StdDraw.text(-0.65, 0.80, "Number of hits: " + String.valueOf(player.getHits()));
            StdDraw.text(-0.65, 0.75, "Total Score: " + String.valueOf(player.getScore()));

            StdDraw.show();
            StdDraw.pause(20);
        }
        while (true) {
            StdDraw.setPenColor(StdDraw.BLUE);
            Font font = new Font("Arial", Font.BOLD, 60);
            StdDraw.setFont(font);
            StdDraw.text(0, 0, "GAME OVER");
            //TO DO: print the rest of the player statistics
            StdDraw.show();
            StdDraw.pause(10);
        }


    }
}
