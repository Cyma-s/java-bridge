package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        makeBridgeGame();
        while (true) {
            progressGameStage();
        }
    }

    public void makeBridgeGame() {
        int bridgeSize = inputView.readBridgeSize();
        this.bridgeGame = new BridgeGame(bridgeSize);
    }

    public void progressGameStage() {
        String userMove = inputView.readMoving();
        GameResult gameResult = bridgeGame.move(userMove);
        outputView.printMap(gameResult);
    }
}