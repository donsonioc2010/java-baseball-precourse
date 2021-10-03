package baseball;

import baseball.VO.GameResultVO;

import java.util.Arrays;

public class GameAdmin {
    private NumberAdmin number;                 // 정답과 플레이어의 정보를 넣을 배열
    private boolean gameSwitch;                 // 정답인경우 false로 while문 종료
    private GameResultVO resultVO = new GameResultVO();

    // 생성자의 객체를 선언하면서 정보초기화, NumberAdmin 생성자에서 이미 정규식 검사는 다 하기때문에 따로 하지않아도됨.
    public GameAdmin() {
        this.number = new NumberAdmin();
        gameSwitch = true;
        while(gameSwitch) {
            resultVO.initNumber();
            number.playerSetting();
            doRunGame();
        }
    }

    /* 게임진행 */
    public void doRunGame() {
        if(number.getPlayerVO().getPlayerNumbers() == null &&
                (number.getPlayerVO().getPlayerNumbers().length != number.getComputerVO().getComputerNumbers().length)) {
            System.out.println(Constants.PRT_ERROR);
            return;
        }
        confirmGameResult();
    }

    /* 게임 결과 확인 */
    public void confirmGameResult() {
        setStrikeCnt();
        setBallCnt();
        setGameResult();
        showGameResult();
    }

    /* 게임의 결과를 Console출력 */
    public void showGameResult() {
        System.out.println();
        if(showStrike()) {
            return;
        }
        if(resultVO.getBallCnt() > 0) {
            System.out.println( " " + resultVO.getBallCnt() + Constants.PRT_BALL );
        }
        if(resultVO.getBallCnt() == 0 && resultVO.getStrikeCnt() == 0) {
            System.out.print(Constants.PRT_NOTHING);
        }
    }

    /* strike의 경우 3개면 게임을 종료해야하기에 따로 구분, 3스트라이크면 다음문장 필요없기에 분기추가. */
    public boolean showStrike() {
        if(resultVO.getStrikeCnt() > 0) {
            System.out.print( resultVO.getStrikeCnt() + Constants.PRT_STRIKE );
        }
        if(resultVO.getStrikeCnt() >= 3) {
            System.out.println();
            System.out.println( Constants.PRT_ENDGAME);
            return true;
        }
        return false;
    }

    /* 3스트라이크인 경우 showStrike에서 실행함. while종료를 위해 실행 */
    public void setGameResult() {
        if(resultVO.getStrikeCnt() == 3) {
            gameSwitch = false;
        }
    }

    /* 스트라이크 갯수 확인 */
    public void setStrikeCnt() {
        for(int i = 0; i < Constants.GAME_ARY_LENGTH; i++) {
            addStrikeCnt(
                    number.getComputerVO().getComputerNumbers(i),
                    number.getPlayerVO().getPlayerNumbers(i)
            );
        }
    }
    /* 문자열 일치시에 스트라이크 카운트 증가 */
    public void addStrikeCnt(String cNum, String pNum){
        if(cNum.equals(pNum)) {
            resultVO.setStrikeCnt(resultVO.getStrikeCnt() + 1);
        }
    }

    /* 볼 갯수 확인 */
    public void setBallCnt() {
        for(int i = 0 ; i < Constants.GAME_ARY_LENGTH; i++) {
            setBallCntComputer(i);
        }
    }

    /* 볼 갯수 확인, 플레이어와 컴퓨터의 비교를 위해 플레이어 Index가져옴 */
    public void setBallCntComputer(int pIdx) {
        for(int i = 0; i < Constants.GAME_ARY_LENGTH; i++) {
            numberValidation(pIdx, i);
        }
    }

    /* Idx가 서로 같은경우가 아니면 일치확인메소드로 보냄. 일치한경우는 볼이기에 return함 */
    public void numberValidation(int pIdx, int cIdx) {
        if(pIdx == cIdx) {
            return;
        }
        addBall(
            number.getComputerVO().getComputerNumbers(cIdx),
            number.getPlayerVO().getPlayerNumbers(pIdx)
        );
    }

    /* 문자열 일치시에 볼 카운트 증가 */
    public void addBall(String cNum, String pNum) {
        if(cNum.equals(pNum)) {
            resultVO.setBallCnt(resultVO.getBallCnt() + 1);
        }
    }
}
