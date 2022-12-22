import java.util.Scanner;

public class Main {
    public static Jokenpo startGame() {
        // Initializing the game
        System.out.println("******** Jokenpô ********\n");

        // Allow the user to enter his name
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String playerName = scan.next().toUpperCase();

        // Create the players' objects
        Player user = new Player(playerName);
        Player IA = new Player("IA");

        // Allow the user to enter how many rounds he wants to play
        System.out.print(playerName + ", informe quantas rodadas você deseja jogar: ");
        int rounds = scan.nextInt();

        return new Jokenpo(user, IA, rounds);
    }

    public static void main(String[] args) {
        // Call the methods for running the game
        Jokenpo Jokenpo = startGame(); // Start the game
        Jokenpo.toPlay(); // Makes the game
        Jokenpo.showFinalResult(); // Show the result
    }
}