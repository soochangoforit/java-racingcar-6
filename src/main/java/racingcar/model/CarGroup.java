package racingcar.model;

import java.util.List;

public class CarGroup {
    private final List<Car> cars;

    private CarGroup(List<Car> cars) {
        this.cars = cars;
    }

    public static CarGroup from(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::from)
                .toList();

        return new CarGroup(cars);
    }

    public void move(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator));
    }

    public List<Car> getCars() {
        return cars;
    }
}
