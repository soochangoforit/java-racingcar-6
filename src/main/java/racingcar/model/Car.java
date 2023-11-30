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

}
