import java.util.Random;
import java.util.Scanner;

public record Jokenpo(
    Player user,
    Player IA,
    int rounds
) {
    // Method of game creation
    public void toPlay() {
        System.out.println("\n******** SEJA BEM VINDO(A), " + user.getName() + " ********\n");

        // Execute the number of rounds entered by the user
        for(int i = 1; i <= rounds; i++) {
            // Storing the user's choice in a variable
            int choiceUser = choiceUser();

            // Validate the user's choice
            if(choiceUser < 1 || choiceUser > 3) {
                System.out.println("\nJOGADA INVÁLIDA!");
                System.out.println("\tPONTO PARA " + IA.getName() + "\n");
                IA.incrementScore();
                continue;
            }

            // Storing the choice of AI in a variable
            int choiceIA = choiceIA();

            // Display each player's bid in the round
            System.out.print("\n" + choiceUser + " X " + choiceIA + '\n');

            // Check who won the round
            int result = choiceUser - choiceIA;
            roundWinner(result);
        }
    }

    // Method for displaying the final result of the game to the user
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

    // Method for checking the winner of the round
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

    // Method to run a random play option
    private int choiceIA() {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

    // Method for choosing a play option
    private int choiceUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - PEDRA");
        System.out.println("2 - PAPEL");
        System.out.println("3 - TESOURA");

        System.out.print("Informe sua jogada: ");

        return scan.nextInt();
    }
}
