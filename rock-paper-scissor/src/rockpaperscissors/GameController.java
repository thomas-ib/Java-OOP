package rockpaperscissors;

import java.util.Random;

public class GameController {

    private GameOption userChoice = GameOption.EMPTY;
    private GameOption machineChoice = GameOption.EMPTY;
    private Score totalScore = new Score();

    public String welcomeMessage() {
        return "        welcome to              \n" +
               "    Rock Paper Scissors Game    \n";
    }

    public String pleaseEnterOptionMessage() {
        return "        Please enter:           \n" +
               "        1. ROCK                 \n" +
               "        2. PAPER                \n" +
               "        3. SCISSOR              \n";
    }

    public void selectUserChoice(GameOption option) {
        this.userChoice = option;
    }

    public GameOption pickRandomlyMachineChoice() {
        int randomNumberBetween1and3 = new Random().nextInt(3) + 1;
        GameOption machOption = GameOption.valueOf(randomNumberBetween1and3);
        this.machineChoice = machOption;
        return machOption;
    }

    public Player calculateResults() {
        totalScore.incrementTotal();
        if (machineChoice.equals(userChoice)) {
            return Player.TIE;
        }
        if (machineChoice.isWinBy(userChoice)) {
            totalScore.incrementGameWonByUser();
            return Player.USER;
        } else {
            return Player.MACHINE;
        }
    }

    public Score getResults() {
        return totalScore;
    }
}
