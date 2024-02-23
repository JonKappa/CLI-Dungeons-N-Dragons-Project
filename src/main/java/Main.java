import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Game dnd = new Game();
        dnd.createTeams();
        dnd.viewTeams();
        int pI = 0;
        int cI = 0;
        while (dnd.player.team.size() > 1 && dnd.computer.team.size() > 1) {
            System.out.println("\nYour Turn!");

            if (pI == 0) {
                System.out.print("Attack with: ");
                pI = scanner.nextInt();
            }

            if (pI > dnd.player.team.size() - 1) {
                System.out.println("Please pick between Characters 1 through 3.");

                pI = 0;
                dnd.viewTeams();

                continue;
            }

            if (cI == 0) {
                System.out.print("Attack Enemy: ");
                cI = scanner.nextInt();
            }

            if (cI > dnd.player.team.size() - 1) {
                System.out.println("Please pick between Characters 1 through 3.");

                try {
                    Thread.sleep(2000);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }

                cI = 0;
                dnd.viewTeams();

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

            if (dnd.player.team.get(pI).getSpeed() >= dnd.computer.team.get(cI).getSpeed()) {
                // if player goes first on players turn
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
                // if computer goes first on player turn
                System.out.println("Enemy " + dnd.computer.team.get(cI).getName() + " goes first!");
                dnd.compTurn(pI, cI);
                if (dnd.player.team.get(pI).currentHealth == 0) {
                    dnd.player.team.remove(pI);
                    dnd.player.team.trimToSize();
                    if (dnd.isGameOver()) {
                        break;
                    }
                } else {
                    // computer counterattacks on player turn if their health is not 0
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
                // if computer goes first on computers turn
                System.out.println("Enemy " + dnd.computer.team.get(cI).getName() + " goes first!");
                dnd.compTurn(pI, cI);
                if (dnd.player.team.get(pI).currentHealth == 0) {
                    dnd.player.team.remove(pI);
                    dnd.player.team.trimToSize();
                    if (dnd.isGameOver()) {
                        break;
                    }
                } else {
                    // players character counterattacks if health is not 0
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
                // if player goes first on computers turn
                System.out.println("Your " + dnd.player.team.get(pI).getName() + " goes first!");
                dnd.playerTurn(pI, cI);
                if (dnd.computer.team.get(cI).getCurrentHealth() == 0) {
                    dnd.computer.team.remove(cI);
                    dnd.computer.team.trimToSize();
                    if (dnd.isGameOver()) {
                        break;
                    }
                } else {
                    // computer counterattacks on computer turn if their health is not 0
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

            dnd.viewTeams();
            pI = 0;
            cI = 0;
        }
    }
}
