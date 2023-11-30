package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.model.NumberGenerator;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        RaceGameController raceGameController = new RaceGameController(inputView, outputView, numberGenerator);
        raceGameController.run();
    }
}
