package racingcar.model;

public class RacingGame {
    private final CarGroup carGroup;

    private RacingGame(CarGroup carGroup) {
        this.carGroup = carGroup;
    }

    public static RacingGame of(CarGroup carGroup) {
        return new RacingGame(carGroup);
    }

    public CarGroup play(NumberGenerator numberGenerator) {
        carGroup.move(numberGenerator);
        return carGroup;
    }

    public CarGroup findWinners() {
        return carGroup.findWinners();
    }
}
