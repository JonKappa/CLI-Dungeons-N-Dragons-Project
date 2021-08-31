import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Game dnd = new Game();
        dnd.createTeams();
        dnd.viewTeams();
        while (dnd.player.team.size() > 1 && dnd.computer.team.size() > 1) {
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
                    if (dnd.computer.team.get(cI).getCurrentHealth() == 0) {
                        dnd.computer.team.remove(cI);
                        dnd.computer.team.trimToSize();
                        if (dnd.isGameOver()) {
                            break;
                        }
                    } else {
                        System.out.println("Enemy " + dnd.computer.team.get(cI).getName() + " counterattacks!");
                        dnd.compTurn(pI, cI);
                        if (dnd.player.team.get(pI).currentHealth <= 0) {
                            dnd.player.team.remove(pI);
                            dnd.player.team.trimToSize();
                            if (dnd.isGameOver()) {
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Enemy " + dnd.computer.team.get(cI).getName() + " goes first!");
                    dnd.compTurn(pI, cI);
                    if (dnd.player.team.get(pI).currentHealth == 0) {
                        dnd.player.team.remove(pI);
                        dnd.player.team.trimToSize();
                        if (dnd.isGameOver()) {
                            break;
                        }
                    } else {
                        System.out.println("Your " + dnd.player.team.get(pI).getName() + " counterattacks!");
                        dnd.playerTurn(pI, cI);
                        if (dnd.computer.team.get(cI).getCurrentHealth() == 0) {
                            dnd.computer.team.remove(cI);
                            dnd.computer.team.trimToSize();
                            if (dnd.isGameOver()) {
                                break;
                            }
                        }
                    }
                }
                System.out.println("\nEnemy Turn!");
                pI = random.nextInt((dnd.player.team.size() - 1) + 1 - 1) + 1;
                cI = random.nextInt((dnd.computer.team.size() - 1) + 1 - 1) + 1;
                System.out.println(pI);
                System.out.println(cI);
                if (dnd.player.team.get(pI).getSpeed() < dnd.computer.team.get(cI).getSpeed()) {
                    System.out.println("Enemy " + dnd.computer.team.get(cI).getName() + " goes first!");
                    dnd.compTurn(pI, cI);
                    if (dnd.player.team.get(pI).currentHealth == 0) {
                        dnd.player.team.remove(pI);
                        dnd.player.team.trimToSize();
                        if (dnd.isGameOver()) {
                            break;
                        }
                    } else {
                        System.out.println("Your " + dnd.player.team.get(pI).getName() + " counterattacks!");
                        dnd.playerTurn(pI, cI);
                        if (dnd.computer.team.get(cI).getCurrentHealth() == 0) {
                            dnd.computer.team.remove(cI);
                            dnd.computer.team.trimToSize();
                            if (dnd.isGameOver()) {
                                break;
                            }
                        }

                    }
                } else {
                    System.out.println("Your " + dnd.player.team.get(pI).getName() + " goes first!");
                    dnd.playerTurn(pI, cI);
                    if (dnd.computer.team.get(cI).getCurrentHealth() == 0) {
                        dnd.computer.team.remove(cI);
                        dnd.computer.team.trimToSize();
                        if (dnd.isGameOver()) {
                            break;
                        }
                    } else {
                        System.out.println("Enemy " + dnd.computer.team.get(cI).getName() + " counterattacks!");
                        dnd.compTurn(pI, cI);
                        if (dnd.player.team.get(pI).currentHealth == 0) {
                            dnd.player.team.remove(pI);
                            dnd.player.team.trimToSize();
                            if (dnd.isGameOver()) {
                                break;
                            }
                        }
                    }
                }
            }
            dnd.viewTeams();
        }
    }
}
