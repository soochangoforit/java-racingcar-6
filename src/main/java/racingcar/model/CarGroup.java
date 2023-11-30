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

    public CarGroup findWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winners = findSamePositionWith(maxPosition);

        return new CarGroup(winners);
    }

    private List<Car> findSamePositionWith(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition().getPosition() == maxPosition)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .map(CarPosition::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("자동차의 최대 위치를 찾을 수 없습니다."));
    }

    public List<Car> getCars() {
        return cars;
    }
}
