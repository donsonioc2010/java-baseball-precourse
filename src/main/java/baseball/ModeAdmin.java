package baseball;


import nextstep.utils.Console;

public class ModeAdmin {
    private boolean getInValConfirm = true;
    public ModeAdmin() {
    }
    /* 게임의 시작과 종료의 결과를 알려줄 메소드 게임의 시작 */
    public boolean getRestartVal() {
        String runMode = null;
        while(getInValConfirm){
            System.out.print(Constants.PRT_REGAME);
            runMode = Console.readLine().trim();
            validationModeVal(runMode);
        }
        System.out.println();
        return confirmValue(runMode);
    }

    /* 정상적인 값을 받으면 어떤값인지 리턴함  값이 1인경우 true그래야 게임이 재시작함. 해당 메소드는 값이 무조건 정상인 경우만 실행함. */
    private boolean confirmValue(String runMode) {
        return Constants.REGAME_VAL.equals(runMode);
    }


    /* 받은 문자열이 정상인지 확인 후 오류시 메세지 출력, 1 또는 2인 경우에만 true 해야함 */
    private void validationModeVal(String runMode) {
        if(Constants.REGAME_VAL.equals(runMode) || Constants.ENDGAME_VAL.equals(runMode)) {
            getInValConfirm = false;
            return;
        }
        System.out.println(Constants.PRT_ERROR);
        getInValConfirm = true;
    }

}
