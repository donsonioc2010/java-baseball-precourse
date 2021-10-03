package baseball.VO;

import baseball.Constants;

import java.util.Arrays;

public class PlayerNumberVO {
    public String[] playerNumbers              = null;
    public String playerNumberStr              = null;


    public PlayerNumberVO() {
    }

    public void initValue() {
        playerNumbers = null;
        playerNumberStr = null;
    }

    public void setAry() {
        playerNumbers = new String[Constants.GAME_ARY_LENGTH];    // 플레이어의 넘버를 기억하는 배열
        Arrays.fill(playerNumbers, null);
    }

    public String[] getPlayerNumbers() {
        return playerNumbers;
    }

    public String getPlayerNumbers(int idx){
        return playerNumbers[idx];
    }

    public void setPlayerNumbers(String[] playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public void setPlayerNumbers(int idx, String setValue) {
        this.playerNumbers[idx] = setValue;
    }

    public String getPlayerNumberStr() {
        return playerNumberStr;
    }

    public void setPlayerNumberStr(String playerNumberStr) {
        this.playerNumberStr = playerNumberStr;
    }
}
