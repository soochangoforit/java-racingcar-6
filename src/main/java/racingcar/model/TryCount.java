package racingcar.model;

public class TryCount {
    private final int count;

    private TryCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.");
        }
    }

    public static TryCount from(int count) {
        return new TryCount(count);
    }
}
