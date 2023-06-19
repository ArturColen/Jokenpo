import java.util.Scanner;

public class Main {
    public static Jokenpo startGame() {
        System.out.println("******** Jokenpô ********\n");

        Scanner scan = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String playerName = scan.next().toUpperCase();

        Player user = new Player(playerName);
        Player IA = new Player("IA");

        System.out.print(playerName + ", informe quantas rodadas você deseja jogar: ");
        int rounds = scan.nextInt();

        return new Jokenpo(user, IA, rounds);
    }

    public static void main(String[] args) {
        Jokenpo Jokenpo = startGame();
        Jokenpo.toPlay();
        Jokenpo.showFinalResult();
    }
}
