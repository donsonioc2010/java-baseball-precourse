package baseball;

import baseball.VO.ComputerNumberVO;
import baseball.VO.PlayerNumberVO;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.Arrays;

public class NumberAdmin {
    public ComputerNumberVO computerVO;
    public PlayerNumberVO   playerVO;

    /* Computer와 Player의 정보를 초기화해주는 기능. */
    public NumberAdmin() {
        computerVO  = new ComputerNumberVO();
        playerVO    = new PlayerNumberVO();
        this.setComputerNumbers();
    }

    /* 플레이어의 정답 셋팅 */
    public void playerSetting() {
        playerVO.initValue();
        this.getNumberByPlayer();
        if(this.validationPlayerStr()) {
            playerVO.setAry();
            this.setPlayerNumbersInputAry();
        }
    }

    /* 플레이어의 숫자를 받는 메소드*/
    public void getNumberByPlayer() {
        System.out.print(Constants.GET_NUM_STR);
        playerVO.setPlayerNumberStr(Console.readLine().trim());
    }

    /* 플레이어의 값이 정상적으로 입력한 경우에만 실행이 됨. validation이 필요가없슴. */
    public void setPlayerNumbersInputAry() {
        for(int i = 0; i < Constants.GAME_ARY_LENGTH; i++) {
            char confirmStr = playerVO.getPlayerNumberStr().charAt(i);
            playerVO.setPlayerNumbers(i, String.valueOf(confirmStr));
        }
    }

    /*  플레이어의 입력 값에 대한 validation
    *   TRUE 조건     : 입력값의 length가 3, 모두다 숫자로 이루어져 있을시
    *   FALSE 조건    : 입력값의 length가 3이 아니거나 또는 입력값에 숫자가 아닌 다른값이 있는경우.
    * */
    public boolean validationPlayerStr() {
        int idx = 0;
        boolean resultValue = playerVO.getPlayerNumberStr().length() == Constants.GAME_ARY_LENGTH;
        while(idx < Constants.GAME_ARY_LENGTH && resultValue) {
            char num = playerVO.getPlayerNumberStr().charAt(idx);
            resultValue = validationPlayerNumberChar(num);
            idx++;
        }
        return resultValue;
    }

    /* 받은 char가 1~9 사이인 경우 true, 아니면 false */
    public boolean validationPlayerNumberChar(char num){
        return num >= 1 && num <= 9;
    }

    /* 컴퓨터의 숫자를 배열로 설정함. 중복이 아닌경우에만 idx가 증가하면서 배열세팅*/
    private void setComputerNumbers() {
        int idx = 0;
        while(idx < Constants.GAME_ARY_LENGTH){
            idx = this.setComputerNumbersInputAry(idx,
                    Randoms.pickNumberInRange(
                            Constants.START_CARD_NUMBER, Constants.END_CARD_NUMBER
                    ));
        }
    }

    /*
    * 중복이 아닌경우 넣을 index값과 뽑은 숫자를 매개변수로 받게됨.
    * validation검사를 통해 true false값을 리턴받음. true인 경우에는 뽑은 값(rndNum)이 중복이 아님으로
    * computerNumbers에 받은 index번째 방에 rndNum값을 삽입후 index값을 증가시켜주며
    * rndNum이 중복인 경우에는 증가하지 않은 값을 return해줌으로 다시 해당 index로 다른 rndNum을 받을 수 있도록 함.
    * */
    private int setComputerNumbersInputAry(int idx, int rndNum) {
        if(validationComputerRndNum(rndNum)) {
            computerVO.setComputerNumbers(idx, String.valueOf(rndNum));
            return idx + 1;
        }
        return idx;
    }

    /*
        컴퓨터의 정답 세팅때 사용이됨.
        rndNum이 현재 뽑은 값인경우 recordNumbers배열에 true로 선언이되어있슴.
        그러면 return 값을 false로 넘겨주며
        recordNumber배열에 없는 값인 경우 false 로 선언이 되어있어서 if문을 타지않고
        recordNumbers배열의 해당 값을 true 로 바꾼 이후 return 값을 true로 넘겨주게됨.
    */
    private boolean validationComputerRndNum(int rndNum) {
        if(computerVO.getRecordNumbers(rndNum)) {
            return false;           //이미 값이 있는경우
        }
        computerVO.setRecordNumbers(rndNum, true);
        return true;                //값이 없는 경우
    }

    public ComputerNumberVO getComputerVO() {
        return computerVO;
    }

    public PlayerNumberVO getPlayerVO() {
        return playerVO;
    }
}
