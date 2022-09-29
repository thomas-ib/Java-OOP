package rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        GameController gameController = new GameController();

        Scanner scanner = new Scanner(System.in);

        String userWantsToExit;

        System.out.println(gameController.welcomeMessage());

        do {
            System.out.println(gameController.pleaseEnterOptionMessage());
            int userOptionRaw = scanner.nextInt();
            GameOption userOption = GameOption.valueOf(userOptionRaw);

            gameController.selectUserChoice(userOption);

            GameOption machineOption = gameController.pickRandomlyMachineChoice();

            Player winner = gameController.calculateResults();

            Score score = gameController.getResults();

            System.out.printf("You played: %s and the machine played %s \n", userOption.name(), machineOption.name());

            if (Player.USER.equals(winner)) {
                System.out.println("You won");
            }
            if (Player.TIE.equals(winner)) {
                System.out.println("Tie!");
            }
            System.out.printf("You won %d games out of %d \n", score.getGamesWonByUser(), score.getTotalNumberGames());
            System.out.println("Continue playing? (Y/N)");
            userWantsToExit = scanner.next();
        } while(userWantsToExit.toUpperCase().equals("Y"));

        scanner.close();
    }
    
}
