package racingcar.model;

import static racingcar.model.ExceptionMessage.POSITION_UNDER_LIMIT_FORMAT_MESSAGE;

import java.util.Objects;

public final class CarPosition {
    private static final int MIN_POSITION = 0;
    private final int position;

    private CarPosition(int position) {
        validateMin(position);
        this.position = position;
    }

    private void validateMin(int position) {
        if (isLessThanMin(position)) {
            String exceptionMessage = String.format(POSITION_UNDER_LIMIT_FORMAT_MESSAGE, MIN_POSITION);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isLessThanMin(int position) {
        return position < MIN_POSITION;
    }

    public static CarPosition initialPosition() {
        return new CarPosition(MIN_POSITION);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
