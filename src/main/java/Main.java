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

        Player player = dnd.player;
        Player computer = dnd.computer;

        while (! dnd.isGameOver()) {
            dnd.clear();
            dnd.viewTeams();
            System.out.println("\nYour Turn!");

            if (dnd.pIndex == 0) {
                System.out.print("Attack with: ");
                dnd.pIndex = scanner.nextInt();
            }

            if (dnd.pIndex <= 0 || dnd.pIndex > player.teamSize()) {
                System.out.println("Please pick between Characters 1 through" + player.teamSize() + ".");
                dnd.sleep(2000);
                dnd.pIndex = 0;

                continue;
            }

            if (dnd.cIndex == 0) {
                System.out.print("Attack Enemy: ");
                dnd.cIndex = scanner.nextInt();
            }

            if (dnd.cIndex <= 0 || dnd.cIndex > computer.teamSize()) {
                System.out.println("Please pick between Characters 1 through" + computer.teamSize() + ".");
                dnd.sleep(2000);
                dnd.cIndex = 0;

                continue;
            }

            dnd.clear();

            Character playerChar = player.getChar(dnd.pIndex);
            Character computerChar = computer.getChar(dnd.cIndex);

            if (dnd.compareSpeed(playerChar, computerChar)) {
                dnd.playerTurn(playerChar, computerChar);
            } else {
                dnd.compTurn(computerChar, playerChar);
            }

            dnd.counterAttack = false;

            if (dnd.isGameOver()) {
                break;
            }

            scanner = new Scanner(System.in);
            scanner.nextLine();

            System.out.println("\nEnemy Turn!");

            dnd.pIndex = random.nextInt((player.teamSize()) + 1 - 1) + 1;
            dnd.cIndex = random.nextInt((computer.teamSize()) + 1 - 1) + 1;

            System.out.println(dnd.pIndex);
            System.out.println(dnd.cIndex);

            playerChar = player.getChar(dnd.pIndex);
            computerChar = computer.getChar(dnd.cIndex);

            if (dnd.compareSpeed(computerChar, playerChar)) {
                dnd.compTurn(computerChar, playerChar);
            } else {
                dnd.playerTurn(playerChar, computerChar);
            }

            dnd.counterAttack = false;

            if (dnd.isGameOver()) {
                break;
            }

            System.out.println("Press \"ENTER\" to continue...");

            scanner = new Scanner(System.in);
            scanner.nextLine();

            dnd.pIndex = 0;
            dnd.cIndex = 0;
        }
    }
}
