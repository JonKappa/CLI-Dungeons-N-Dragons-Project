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

            if (pI > dnd.player.team.size() - 1 || pI <= 0) {
                System.out.println("Please pick between Characters 1 through" + (dnd.player.team.size() - 1) + ".");
                dnd.sleep(2000);
                pI = 0;

                continue;
            }

            if (cI == 0) {
                System.out.print("Attack Enemy: ");
                cI = scanner.nextInt();
            }

            if (cI > dnd.computer.team.size() - 1|| cI <= 0) {
                System.out.println("Please pick between Characters 1 through 3.");
                dnd.sleep(2000);
                cI = 0;

                continue;
            }

            dnd.clear();

            if (dnd.compareSpeed(dnd.player.team.get(pI), dnd.computer.team.get(cI))) {
                dnd.playerTurn(pI, cI);
            } else {
                dnd.compTurn(pI, cI);
            }

            if (dnd.isGameOver()) {
                break;
            }

            scanner = new Scanner(System.in);
            scanner.nextLine();

            System.out.println("\nEnemy Turn!");

            pI = random.nextInt((dnd.player.team.size() - 1) + 1 - 1) + 1;
            cI = random.nextInt((dnd.computer.team.size() - 1) + 1 - 1) + 1;

            System.out.println(pI);
            System.out.println(cI);

            if (dnd.compareSpeed(dnd.player.team.get(pI), dnd.computer.team.get(cI))) {
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
