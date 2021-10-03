package baseball.VO;

import baseball.Constants;

import java.util.Arrays;

public class ComputerNumberVO {
    private  String[] computerNumbers;
    private Boolean[] recordNumbers;

    public ComputerNumberVO() {
        computerNumbers = new String[Constants.GAME_ARY_LENGTH];    // 컴퓨터 넘버를 기억하는 배열
        recordNumbers   = new Boolean[Constants.NUMBER_AREA];         // 1 ~ 9 로 사용을 위해 10을선언, 0은 사용안함
        Arrays.fill(computerNumbers, null);
        Arrays.fill(recordNumbers, false);
    }

    public String[] getComputerNumbers() {
        return computerNumbers;
    }

    public String getComputerNumbers(int idx) {
        return computerNumbers[idx];
    }

    public void setComputerNumbers(String[] computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public void setComputerNumbers(int idx, String setValue) {
        this.computerNumbers[idx] = setValue;
    }

    public Boolean[] getRecordNumbers() {
        return recordNumbers;
    }

    public Boolean getRecordNumbers(int idx) {
        return recordNumbers[idx];
    }

    public void setRecordNumbers(Boolean[] recordNumbers) {
        this.recordNumbers = recordNumbers;
    }

    public void setRecordNumbers(int idx, boolean setValue) {
        this.recordNumbers[idx] = setValue;
    }
}
