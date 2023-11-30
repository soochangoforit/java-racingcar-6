package racingcar.model;

public class CarPosition {
    private final int position;

    private CarPosition(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차의 위치는 음수가 될 수 없습니다.");
        }
    }

    public static CarPosition defaultPosition() {
        return new CarPosition(0);
    }
}
