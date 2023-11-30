package racingcar.controller;

import java.util.List;
import java.util.function.Supplier;
import racingcar.model.CarGroup;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CarGroup carGroup = fetch(this::readCarNames);
        TryCount tryCount = fetch(this::readTryCount);
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
