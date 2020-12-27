/**
 * @author LinusW
 * @create 2020-12-13-7:50 PM
 */
public class Player {
    private int successHits;
    private int score;
    private String ballType;

    public Player(int successHits, int score, String ballType) {
        this.successHits = successHits;
        this.score = score;
        this.ballType = ballType;
    }

    public int getSuccessHits() {
        return successHits;
    }

    public void hits() {
        successHits += 1 ;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public String getBallType() {
        return ballType;
    }

    public void setBallType(String ballType) {
        this.ballType = ballType;
    }


    public int getHits() {
        return successHits;
    }
}
