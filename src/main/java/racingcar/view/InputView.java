package racingcar.view;

import java.util.List;
import java.util.stream.Stream;
import camp.nextstep.edu.missionutils.Console;
import racingcar.view.validator.BlankValidator;
import racingcar.view.validator.CarNamesValidator;
import racingcar.view.validator.DigitsOnlyValidator;

public class InputView {

    public List<String> readCarNames() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();
        validateCarNames(carNames);
        return split(",", carNames);
    }

    public int readTryCount() {
        println("시도할 회수는 몇회인가요?");
        String rawTryCount = readLine();
        validateTryCount(rawTryCount);
        return convertToInt(rawTryCount);
    }

    private void validateTryCount(String rawTryCount) {
        BlankValidator.validate(rawTryCount);
        DigitsOnlyValidator.validate(rawTryCount);
    }

    private void validateCarNames(String carNames) {
        BlankValidator.validate(carNames);
        CarNamesValidator.validate(carNames);
    }

    private String readLine() {
        return Console.readLine().trim();
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private List<String> split(String format, String input) {
        return List.of(input.split(format));
    }

    private List<Integer> splitToInt(String delimiter, String input) {
        return Stream.of(input.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 문자입니다.");
        }
    }
}
