# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)



## 기능 요구사항
* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방*(*컴퓨터*)*의 수를 맞추면 승리한다.
  * [*예*]상대방(컴퓨터)*의 수가425일때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1스트라이크 1볼, 789를 제시한 경우 : 낫싱
* 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는1에서 9까지 서로 다른 임의의 수 3개를 선택한다.게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
* 사용자가 잘못된 값을 입력할 경우 *[*ERROR*]*로 시작하는 에러 메시지를 출력하고 게임을 계속 진행할 수 있어야 한다.

## 실행 결과
숫자를입력해주세요:123<br>
1스트라이크1볼<br>
숫자를입력해주세요:145<br>
1볼<br>
숫자를입력해주세요:671<br>
2볼<br>
숫자를입력해주세요:216<br>
8<br>
1스트라이크<br>
숫자를입력해주세요:713<br>
3스트라이크<br>
3개의숫자를모두맞히셨습니다!게임끝<br>
게임을새로시작하려면1,종료하려면2를입력하세요. 1<br>
숫자를입력해주세요:123<br>
1볼 <br>


## 구현할 기능
* 공통부분
  * 문자열을 사용할 상수값 지정
 
* 게임 진행관련
  * 게임의 시작 재시작을 묻고 true, false를 받는 기능.

* 게임 시작
  * Computer와 Player의 정보를 초기화해주는 기능.
  * Computer의 배열 세팅 및 Validation
  * Player의 숫자 입력 및 Validation
  * 정답 확인
    * 스트라이크, 볼 확인
  * 결과 발표