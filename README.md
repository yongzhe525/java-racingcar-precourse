# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능구현

* Car :  차량 정보를 가진 class
  * name : 이름, String
  * length : 이동 거리, int
  * Car : 차량 이름을 바탕으로 차량을 생성하는 생성자 
  * isMove : 랜덤함수를 이용해 차량 전진 여부 판단
  * moveCar : isMove함수를 통해 전진/정지 결과 저장
  * getMovement : 차량 이동 정보 반환
  * printMovement : 차량 이동 상황 출력
  * getName : 차량 명칭 출력
  * setLength : 차량 이동거리 강제 입력 for 테스트 
  
* CarGroup : Car 객체들을 관리하는 클래스
  * Cars : List<Car> 차량 객체를 관리하는 collection 클래스 생성
  * CarGroup : 차량 객체를 관리하는 그룹을 생성하는 생성자
  * moveCars : 차량객체 전진
  * carsMovementProcess : 차량 객체 전진/정지 상태 저장 
  * movementShorting : 차량 객체 이동 현황 정렬
  * getMaximunMovement : 차량 객체중 최대 이동 거리 구하기
  * printCarsMovement : 차량 이동 상황 출력 
  * getWinners : 최대 이동거리 기반으로 최종 우승자 찾기
  * getCarListWithPredicate : predicate 조건에 만족하는 차량만 최종 저장해주는 기능
  
* RaceGame :  경주게임 제어 class
  * start : 시작
  * getCarNames : 사용자가 입력한 경주할 자동차 이름을 처리하는 기능 (쉼표처리 포함)
  * getRaceCount : 사용자가 입력한 시도한 회수 구하는 메소드
  * printWinners : 최종 우승자 출력 
* run : 경주게임 시작, 최종 값 리턴
  
* Main : application 동작 클래스
  * main : application 실행

* PreconditionCheck : 예외처리가 필요한 항목에 대한 필터 클래스
  * isValidRaceCount : 입력 받은 race 시도 회수에 대한 정합성 체크
  * isValidCarNames : 5자 이하, 쉼표 구분 가능한 string인지 정합성 체크
  