package racingcar.controller;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import racingcar.model.CarGroup;
import racingcar.model.NumberGenerator;
import racingcar.model.RacingGame;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RaceGameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        CarGroup carGroup = fetch(this::readCarNames);
        TryCount tryCount = fetch(this::readTryCount);
        RacingGame racingGame = RacingGame.of(carGroup);
        Stream.generate(() -> racingGame.play(numberGenerator))
                .limit(tryCount.getCount())
                .forEach(outputView::printResult);
        
    }

    private TryCount readTryCount() {
        int tryCount = inputView.readTryCount();
        return TryCount.from(tryCount);
    }

    private CarGroup readCarNames() {
        List<String> carNames = inputView.readCarNames();
        return CarGroup.from(carNames);
    }

    private <T> T fetch(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return fetch(supplier);
        }
    }

}
