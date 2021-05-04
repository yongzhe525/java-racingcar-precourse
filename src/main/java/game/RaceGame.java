package game;

import java.util.List;
import java.util.Scanner;

public class RaceGame {

    private static final String PLAY_GET_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PLAY_GET_RACE_COUNT = "시도할 횟수는 몇회인가요?";
    private static final String PLAY_RESULT_START = "실행 결과";
    private static final String PLAY_RESULT = "가 최종 우승했습니다.";

    String[] getCarNames(Scanner scanner) {
        System.out.println(PLAY_GET_NAME);
        String[] splitedCarNames;
        String carNames = scanner.next();
        splitedCarNames = carNames.split(",");
        return splitedCarNames;
    }

    int getRaceCount(Scanner scanner) {
        System.out.println(PLAY_GET_RACE_COUNT);
        String strTryCount;
        strTryCount = scanner.next();
        return Integer.valueOf(strTryCount);
    }

    String printWinners(List<Car> winners) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Car winner : winners) {
            stringBuffer.append(winner.getName()).append(", ");
        }
        stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
        stringBuffer.append(PLAY_RESULT);
        return stringBuffer.toString();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String[] carNames = getCarNames(scanner);
        int tryCount = getRaceCount(scanner);
        CarGroup carGroup = new CarGroup(carNames);
        System.out.println(PLAY_RESULT_START);
        for (int index = 0; index < tryCount; index++) {
            carGroup.carsMovementProcess();
            carGroup.printCarsMovement();
        }
        String winner = printWinners(carGroup.getWinners());
        System.out.println(winner);
        scanner.close();
    }
}
