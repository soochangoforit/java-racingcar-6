package racingcar.model;

public class Car {
    private final CarName name;
    private CarPosition position;

    private Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        CarName carName = CarName.from(name);
        CarPosition carPosition = CarPosition.defaultPosition();

        return new Car(carName, carPosition);
    }

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate(1, 9) >= 4) {
            position = position.move();
        }
    }

    public CarName getName() {
        return name;
    }

    public CarPosition getPosition() {
        return position;
    }
}
