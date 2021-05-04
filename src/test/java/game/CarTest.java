package game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"G80"})
    @DisplayName(value = "범위 내 임의의 숫자 생성 여부 테스트")
    public void getRandomValueTest(String carName) {
        Car car = new Car(carName);
        for (int index = 0; index < 10; index++) {
            assertThat(car.getRandomValue()).isLessThan(10);
            assertThat(car.getRandomValue()).isGreaterThanOrEqualTo(0);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"G80"})
    @DisplayName(value = "차량 정상 이동 여부 확인 테스트")
    public void moveTest(String carName) {
        Car car = new Car(carName);
        int moveCount = 0;
        for (int index = 0; index < 100; index++) {
            if (car.isMove()) {
                car.moveCar();
                moveCount++;
            }
        }
        assertThat(car.getMovement()).isEqualTo(moveCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"G80"})
    @DisplayName(value = "차량 이동 진행 상태 출력 테스트")
    public void printMovementTest(String carName) {
        Car car = new Car(carName);
        int moveCount = 0;
        StringBuffer movement = new StringBuffer(carName).append(":");
        for (int index = 0; index < 10; index++) {
            if (car.isMove()) {
                car.moveCar();
                moveCount++;
                movement.append("-");
            }
        }
        assertThat(car.getMovement()).isEqualTo(moveCount);
        assertThat(car.printMovement()).isEqualTo(movement.toString());
    }
}