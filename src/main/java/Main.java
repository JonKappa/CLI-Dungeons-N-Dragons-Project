import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Game dnd = new Game();

        dnd.createTeams();
        int pI = 0;
        int cI = 0;

        while (! dnd.isGameOver()) {
            dnd.clear();
            dnd.viewTeams();
            System.out.println("\nYour Turn!");

            if (pI == 0) {
                System.out.print("Attack with: ");
                pI = scanner.nextInt();
            }

            if (pI > dnd.player.team.size() - 1) {
                System.out.println("Please pick between Characters 1 through 3.");
                dnd.sleep(2000);
                pI = 0;

                continue;
            }

            if (cI == 0) {
                System.out.print("Attack Enemy: ");
                cI = scanner.nextInt();
            }

            if (cI > dnd.player.team.size() - 1) {
                System.out.println("Please pick between Characters 1 through 3.");
                dnd.sleep(2000);
                cI = 0;

                continue;
            }

            if (dnd.player.team.get(pI).getCurrentHealth() == 0) {
                System.out.println("You cant attack with this character, pick again. ");
                continue;
            }
            
            if (dnd.computer.team.get(cI).getCurrentHealth() == 0) {
                System.out.println("You can't attack this character, try again.");
                continue;
            }

            dnd.clear();

            if (dnd.compareSpeed(pI, cI) == "Player") {
                dnd.playerTurn(pI, cI);
            } else {
                dnd.compTurn(pI, cI);
            }

            if (dnd.isGameOver()) {
                break;
            }

            System.out.println("\nEnemy Turn!");
            pI = random.nextInt((dnd.player.team.size() - 1) + 1 - 1) + 1;
            cI = random.nextInt((dnd.computer.team.size() - 1) + 1 - 1) + 1;
            System.out.println(pI);
            System.out.println(cI);

            if (dnd.compareSpeed(pI, cI) == "Player") {
                dnd.playerTurn(pI, cI);
            } else {
                dnd.compTurn(pI, cI);
            }

            if (dnd.isGameOver()) {
                break;
            }

            System.out.println("Press \"ENTER\" to continue...");

            scanner = new Scanner(System.in);
            scanner.nextLine();

            pI = 0;
            cI = 0;
        }
    }
}
