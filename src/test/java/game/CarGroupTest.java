package game;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarGroupTest {

    private String[] carNames;
    private int[] movement;
    private List<Car> carList;

    @BeforeEach
    public void beforeEach() {
        carList = new ArrayList<>();
        Car car1 = new Car("K3");
        Car car2 = new Car("K5");
        Car car3 = new Car("K7");
        Car car4 = new Car("G70");
        Car car5 = new Car("G80");
        car1.setLength(2);
        car2.setLength(2);
        car3.setLength(3);
        car4.setLength(4);
        car5.setLength(5);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);

        movement = new int[5];
        movement[0] = 5;
        movement[1] = 5;
        movement[2] = 3;
        movement[3] = 2;
        movement[4] = 1;
    }

    @Test
    @DisplayName("차량 이동 관련 moveCars 메소드 테스트")
    public void moveCarsTest() {
        int n = 5;
        CarGroup carGroup = new CarGroup(carList);
        for (int index = 1; index <= n; index++) {
            System.out.println(index + " times");
            carGroup.moveCars();
            carGroup.printCarsMovement();
        }
    }

    @Test
    @DisplayName("최장 거리 이동 구하는 메소드 테스트")
    public void getMaximunMovementTest() {
        CarGroup carGroup = new CarGroup(carList);
        carGroup.movementShorting();
        assertThat(carGroup.getMaximunMovement()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Predicate 함수형 인터페이스에 대해 정상 동작하는지 확인하는 테스트")
    public void getCarListWithPredicateTest(Integer input) {
        CarGroup carGroup = new CarGroup(carList);
        List<Car> result = new ArrayList<>();
        Predicate<Car> predicate = car -> car.getMovement() >= input;
        int size = carList.size();
        for (int index = 0; index < size; index++) {
            carGroup.getCarListWithPredicate(carList.get(index), result, predicate);
        }
        assertThat(result.size()).isEqualTo(movement[input-1]);
    }

    @Test
    @DisplayName("자동차 경주 우승자 출력 테스트")
    public void getWinnersTest() {
        CarGroup carGroup = new CarGroup(carList);
        List<Car> result = carGroup.getWinners();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getMovement()).isEqualTo(5);
    }
}