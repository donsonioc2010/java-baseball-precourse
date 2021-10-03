package baseball;

import nextstep.utils.Randoms;

import java.util.Arrays;

public class NumberAdmin {
    private String[] computerNumbers             = new String[Constants.GAME_ARY_LENGTH];    // 컴퓨터의 랜덤넘버를 담기 위함
    private String[] playerNumbers               = new String[Constants.GAME_ARY_LENGTH];    // 플레이어의 넘버를 기억하는 배열
    private String playerNumberStr               = null;
    private Boolean[] recordNumbers             = new Boolean[Constants.NUMBER_AREA];  // 1 ~ 9 로 사용을 위해 10을선언, 0은 사용안함

    /* Computer와 Player의 정보를 초기화해주는 기능. */
    public NumberAdmin() {
        this.initComputerNumbersAry();
        this.setComputerNumbers();
    }

    /* 게임이 시작할 시에 혹시나 모를 플레이어와 컴퓨터의 배열을 초기화에 사용 */
    private void initComputerNumbersAry() {
        Arrays.fill(computerNumbers, null);
        Arrays.fill(playerNumbers, null);
        Arrays.fill(recordNumbers, false);
        playerNumberStr = null;
    }

    /* 컴퓨터의 숫자를 배열로 설정함. 중복이 아닌경우에만 idx가 증가하면서 배열세팅*/
    private void setComputerNumbers() {
        int idx = 0;
        while(idx < Constants.GAME_ARY_LENGTH){
            idx = this.setNumber(idx,
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
    private int setNumber(int idx, int rndNum) {
        if(validationNum(rndNum)) {
            computerNumbers[idx] = String.valueOf(rndNum);
            return idx + 1;
        }
        return idx;
    }

    /*
        rndNum이 현재 뽑은 값인경우 recordNumbers배열에 true로 선언이되어있슴.
        그러면 return 값을 false로 넘겨주며
        recordNumber배열에 없는 값인 경우 false 로 선언이 되어있어서 if문을 타지않고
        recordNumbers배열의 해당 값을 true 로 바꾼 이후 return 값을 true로 넘겨주게됨.
    */
    private boolean validationNum(int rndNum) {
        if(recordNumbers[rndNum]) {
            return false;           //이미 값이 있는경우
        }
        recordNumbers[rndNum] = true;
        return true;                //값이 없는 경우
    }
}
