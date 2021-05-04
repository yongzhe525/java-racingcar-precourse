package game;

import game.Car;
import game.CarGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceGameTest {

    private String carNames;
    private String tryCount;

    private static final String PLAY_RESULT_START = "실행 결과";

    @BeforeEach
    public void beforeEach() {
        carNames = "K3,K5,K7,G70,G80";
        tryCount = "5";
    }

    @Test
    @DisplayName("차량 이름 조회 메소드 확인하는 테스트")
    public void getCarNamesTest() {
        String[] names = new String[]{"K3", "K5", "K7", "G70", "G80"};
        Scanner scanner = new Scanner(carNames);
        RaceGame raceGame = new RaceGame();
        String[] carNames = raceGame.getCarNames(scanner);
        for (int index = 0; index < carNames.length; index++) {
            Assertions.assertThat(names[index]).isEqualTo(carNames[index]);
        }
        scanner.close();
    }

    @Test
    @DisplayName("경주 시도 회수 조회 메소드 확인하는 테스트")
    public void getTryCountTest() {
        Scanner scanner = new Scanner(tryCount);
        RaceGame raceGame = new RaceGame();
        Assertions.assertThat(raceGame.getRaceCount(scanner)).isEqualTo(5);
        scanner.close();
    }

    @Test
    public void printWinnersTest() {
        Scanner scanner = new Scanner(tryCount);
        RaceGame raceGame = new RaceGame();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("G70"));
        cars.add(new Car("G80"));
        raceGame.printWinners(cars);
        String result = "G70, G80가 최종 우승했습니다.";
        System.out.println(raceGame.printWinners(cars));
        Assertions.assertThat(raceGame.printWinners(cars)).isEqualTo(result);

        scanner.close();
    }

    @Test
    public void runTest() {
        Scanner carScanner = new Scanner(carNames);
        Scanner tryCountScanner = new Scanner(tryCount);
        RaceGame raceGame = new RaceGame();
        String[] carNames = raceGame.getCarNames(carScanner);
        int tryCount = raceGame.getRaceCount(tryCountScanner);
        CarGroup carGroup = new CarGroup(carNames);
        System.out.println(PLAY_RESULT_START);
        for (int index = 0; index < tryCount; index++) {
            carGroup.moveCars();
            carGroup.printCarsMovement();
        }
        raceGame.printWinners(carGroup.getWinners());
        carScanner.close();
        tryCountScanner.close();
    }
}