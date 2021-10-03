package baseball.VO;

public class GameResultVO {
    private int strikeCnt;
    private int ballCnt;

    public GameResultVO() {
        initNumber();
    }

    public void initNumber() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public void setStrikeCnt(int strikeCnt) {
        this.strikeCnt = strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void setBallCnt(int ballCnt) {
        this.ballCnt = ballCnt;
    }
}
