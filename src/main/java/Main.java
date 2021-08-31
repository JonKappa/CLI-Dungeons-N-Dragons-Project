import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game dnd = new Game();
        dnd.createTeams();
        dnd.viewTeams();
        while (!dnd.isGameOver()) {
            System.out.println("\nYour Turn!");
            System.out.print("Attack with: ");
            int pI = scanner.nextInt();
            System.out.print("Attack Enemy: ");
            int cI = scanner.nextInt();
            if (dnd.player.team.get(pI).getCurrentHealth() == 0) {
                System.out.println("You cant attack with this character, pick again. ");
            } else if (dnd.computer.team.get(cI).getCurrentHealth() == 0) {
                System.out.println("You can't attack this character, try again.");
            } else {
                if (dnd.player.team.get(pI).getSpeed() >= dnd.computer.team.get(cI).getSpeed()) {
                    System.out.println("Your " + dnd.player.team.get(pI).getName() + " goes first!");
                    dnd.playerTurn(pI, cI);
                    System.out.println("Enemy " + dnd.computer.team.get(cI).getName() + " counterattacks!");
                    dnd.compTurn(pI, cI);
                } else {
                    System.out.println("Enemy " + dnd.computer.team.get(cI).getName() + " goes first!");
                    dnd.compTurn(pI, cI);
                    System.out.println("Your " + dnd.player.team.get(pI).getName() + " counterattacks!");
                    dnd.playerTurn(pI, cI);
                }
                System.out.println("\nEnemy Turn!");
                pI = (int) ((Math.random() * 3) + 1);
                cI = (int) ((Math.random() * 3) + 1);
                while (dnd.player.team.get(pI).getCurrentHealth() == 0 ||dnd.computer.team.get(cI).getCurrentHealth() == 0) {
                    if (dnd.player.team.get(pI).getCurrentHealth() == 0) {
                        pI = (int) ((Math.random() * 3) + 1);
                    }
                    else if (dnd.computer.team.get(cI).getCurrentHealth() == 0) {
                        cI = (int) ((Math.random() * 3) + 1);
                    }
                }
                if (dnd.player.team.get(pI).getSpeed() < dnd.computer.team.get(cI).getSpeed()) {
                    System.out.println("Enemy " + dnd.computer.team.get(cI).getName() + " goes first!");
                    dnd.compTurn(pI, cI);
                    System.out.println("Your " + dnd.player.team.get(pI).getName() + " counterattacks!");
                    dnd.playerTurn(pI, cI);
                } else {
                    System.out.println("Your " + dnd.player.team.get(pI).getName() + " goes first!");
                    dnd.playerTurn(pI, cI);
                    System.out.println("Enemy " + dnd.computer.team.get(cI).getName() + " counterattacks!");
                    dnd.compTurn(pI, cI);
                }
            }
            dnd.viewTeams();
        }
    }
}
