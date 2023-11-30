package racingcar.model;

public class CarName {
    private final String name;

    private CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("공백 문자는 입력할 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    public String getName() {
        return name;
    }
}
