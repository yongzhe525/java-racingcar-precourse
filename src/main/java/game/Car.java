package game;

import java.util.Random;

public class Car {

    private final int GO_STOP_VALUE = 4;
    private final String name;
    private int length;
    private static final Random random = new Random();

    public Car(String name) {
        this.name = name;
        this.length = 0;
    }

    boolean isMove() {
        return getRandomValue() >= GO_STOP_VALUE;
    }

    void moveCar() {
        this.length ++;
    }

    int getMovement() {
        return this.length;
    }

    int getRandomValue() {
        return random.nextInt(10);
    }

    String printMovement() {
        StringBuffer movement = new StringBuffer();
        for (int i = 0; i < length; i++) {
            movement.append("-");
        }
        return new StringBuffer(name).append(":").append(movement).toString();
    }
}