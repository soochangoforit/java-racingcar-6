package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarGroup;

public class OutputView {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";

    public void printExceptionMessage(String message) {
        println(String.format(EXCEPTION_FORMAT, message));
    }

    public void printResult(CarGroup carGroup) {
        List<Car> cars = carGroup.getCars();
        for (Car car : cars) {
            printCarPosition(car);
        }
        printEmptyLine();
    }

    private void printCarPosition(Car car) {
        String carName = car.getName().getName();
        int position = car.getPosition().getPosition();
        String positionString = "-".repeat(position);
        println(String.format("%s : %s", carName, positionString));
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
