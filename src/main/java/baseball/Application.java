package baseball;

/*
    핵심 주의사항
    1. 소스의 Indent가 2를 넘으면 안됨.
    2. 소스의 라인이 하나의 메소드당 10줄을 넘기면 안됨.
 */

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        boolean runMode = true;
        while(runMode){
            new GameAdmin();                            //게임을 관리해줄 메소드
            runMode = new ModeAdmin().getRestartVal();  // 게임의 종료 또는 재시작을 하는 라인
        }
    }
}
