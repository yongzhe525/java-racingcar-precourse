package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class CarGroup {

    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    public void printCarsMovement() {
        for (Car car : cars) {
            System.out.println(car.printMovement());
        }
    }

    void movementShorting() {
        Collections.sort(cars,
                (car1, car2) -> (car1.getMovement() - car2.getMovement()) * -1
        );
    }

    int getMaximunMovement() {
        return cars.get(0).getMovement();
    }

    void getCarListWithPredicate(Car car, List<Car> carList, Predicate<Car> predicate) {
        if (predicate.test(car)) {
            carList.add(car);
        }
    }

    public List<Car> getWinners() {
        int size = cars.size();
        movementShorting();
        int maximumValue = getMaximunMovement();
        List<Car> result = new ArrayList<>();
        Predicate<Car> predicate = car -> car.getMovement() >= maximumValue;
        for (int index = 0; index < size; index++) {
            getCarListWithPredicate(cars.get(index), result, predicate);
        }
        return result;
    }
}