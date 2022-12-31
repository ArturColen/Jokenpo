import java.util.Random;
import java.util.Scanner;

public record Jokenpo(
    Player user,
    Player IA,
    int rounds
) {
    // Create the game
    public void toPlay() {
        System.out.println("\n******** SEJA BEM VINDO(A), " + user.getName() + " ********\n");

        // Execute the number of rounds entered by the user
        for(int i = 1; i <= rounds; i++) {
            int choiceUser = choiceUser();

            // Validate the user's choice
            if(choiceUser < 1 || choiceUser > 3) {
                System.out.println("\nJOGADA INVÁLIDA!");
                System.out.println("\tPONTO PARA " + IA.getName() + "\n");
                IA.incrementScore();
                continue;
            }

            int choiceIA = choiceIA();

            // Display each player's bid in the round
            System.out.print("\n" + choiceUser + " X " + choiceIA + '\n');

            // Check who won the round
            int result = choiceUser - choiceIA;
            roundWinner(result);
        }
    }

    // Display the final result of the game to the user
    public void showFinalResult() {
        System.out.println("\n*************************\n");

        Integer finalScoreUser = user.getScore();
        Integer finalScoreIA = IA.getScore();

        System.out.println("\n\tPLACAR FINAL: " + user.getName() + " " + user.getScore() + " X " + IA.getScore() + " " + IA.getName());

        if(finalScoreUser == finalScoreIA) {
            System.out.println("\t\tEMPATE!");
        }
        else {
            String finalWinner = (finalScoreUser > finalScoreIA) ? user.getName() : IA.getName();
            System.out.println("\t\tVENCEDOR: " + finalWinner.toUpperCase());
        }

        System.out.println("\n*************************\n");


    }

    // Check the winner of the round
    private void roundWinner(int result) {
        String roundWinner;
        if(result == 0) {
            roundWinner = "EMPATE!";
        }
        else if(result == -1 || result == 2) {
            IA().incrementScore();
            roundWinner= IA().getName();
        }
        else {
            user.incrementScore();
            roundWinner = user.getName();
        }
        System.out.println("\nVENCEDOR DA RODADA: " + roundWinner + "\n");
    }

    // Run a random play option
    private int choiceIA() {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

    // Choose a game option
    private int choiceUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - PEDRA");
        System.out.println("2 - PAPEL");
        System.out.println("3 - TESOURA");

        System.out.print("Informe sua jogada: ");

        return scan.nextInt();
    }
}
