import java.util.Random;

public class Game {
    public Player player = new Player();
    public Player computer = new Player();
    int attackRoll;
    int defenseRoll;


    public void createTeams() {
        player.createTeam();
        computer.createTeam();
    }

    public void viewTeams() {
        StringBuilder Teams = new StringBuilder();

        Teams.append("Your Team\n");
        Teams.append("--------------------------------------------------------------------\n");
        // Character Name
        for (int i = 1; i < player.team.size(); i++) {
            Teams.append(String.format("%-24s", player.team.get(i).name + " (" + i + ")"));
        }
            Teams.append("\n");
        // Character Health
        for (int i = 1; i < player.team.size(); i++) {
            Teams.append(String.format("%-24s", " - Health: " + player.team.get(i).getCurrentHealth() + " / " + player.team.get(i).getMaxHealth()));
        }
        Teams.append("\n");
        // Character Attack
        for (int i = 1; i < player.team.size(); i++) {
            Teams.append(String.format("%-24s", " - Attack: " + player.team.get(i).getAttack()));
        }
        Teams.append("\n");
        // Character Defense
        for (int i = 1; i < player.team.size(); i++) {
            Teams.append(String.format("%-24s", " - Defense: " + player.team.get(i).getDefense()));
        }
        Teams.append("\n");
        // Character Speed
        for (int i = 1; i < player.team.size(); i++) {
            Teams.append(String.format("%-24s", " - Speed: " + player.team.get(i).getSpeed()));
        }
        Teams.append("\n\n");

        Teams.append("Enemy Team\n");
        Teams.append("--------------------------------------------------------------------\n");
        // Character Name
        for (int i = 1; i < computer.team.size(); i++) {
            Teams.append(String.format("%-24s", computer.team.get(i).name + " (" + i + ")"));
        }
        Teams.append("\n");
        // Character Health
        for (int i = 1; i < computer.team.size(); i++) {
            Teams.append(String.format("%-24s", " - Health: " + computer.team.get(i).getCurrentHealth() + " / " + computer.team.get(i).getMaxHealth()));
        }
        Teams.append("\n");
        // Character Attack
        for (int i = 1; i < computer.team.size(); i++) {
            Teams.append(String.format("%-24s", " - Attack: " + computer.team.get(i).getAttack()));
        }
        Teams.append("\n");
        // Character Defense
        for (int i = 1; i < computer.team.size(); i++) {
            Teams.append(String.format("%-24s", " - Defense: " + computer.team.get(i).getDefense()));
        }
        Teams.append("\n");
        // Character Speed
        for (int i = 1; i < computer.team.size(); i++) {
            Teams.append(String.format("%-24s", " - Speed: " + computer.team.get(i).getSpeed()));
        }

        System.out.println(Teams);
    }

    public boolean isGameOver() {
        if (player.team.size() == 1) {
            viewTeams();
            System.out.println("The Enemy defeated all of your characters Computer wins!");
            return true;

        }
        else if (computer.team.size() == 1) {
            viewTeams();
            System.out.println("You defeated all of the enemy's characters, you win!");
            return true;
        }
        else {
            return false;
        }
    }


    public void tempStatsPlayer(int pIndex, int cIndex) {
        attackRoll = new Random().nextInt(6 + 1 - 1) + 1;
        defenseRoll = new Random().nextInt(6 + 1 - 1) + 1;
        player.team.get(pIndex).tempAttack = player.team.get(pIndex).getAttack() + attackRoll;
        computer.team.get(cIndex).tempDefense = computer.team.get(cIndex).getDefense() + defenseRoll;
    }
    public void tempStatsComp(int pIndex, int cIndex) {
        attackRoll = new Random().nextInt(6 + 1 - 1) + 1;
        defenseRoll = new Random().nextInt(6 + 1 - 1) + 1;
        computer.team.get(cIndex).tempAttack = computer.team.get(cIndex).getAttack() + attackRoll;
        player.team.get(pIndex).tempDefense = player.team.get(pIndex).getDefense() + defenseRoll;
    }
    public void playerTurn(int pIndex, int cIndex) {
        // Player's attack
        int damage;
        tempStatsPlayer(pIndex, cIndex);
        System.out.print("Your " + player.team.get(pIndex).getName() + "'s Attack: ");
        System.out.println("Base of " + player.team.get(pIndex).getAttack() + " + Roll of " + attackRoll + " = " + player.team.get(pIndex).tempAttack);
        System.out.print("Enemy " + computer.team.get(cIndex).getName() + "'s Defense: ");
        System.out.println("Base of " + computer.team.get(cIndex).getDefense() + " + Roll of " + defenseRoll + " = " + computer.team.get(cIndex).tempDefense);
        if (player.team.get(pIndex).tempAttack - computer.team.get(cIndex).tempDefense <= 0) {
            damage = 0;
        } else {
            damage = player.team.get(pIndex).tempAttack - computer.team.get(cIndex).tempDefense;
            if (computer.team.get(cIndex).currentHealth - damage < 0) {
                computer.team.get(cIndex).currentHealth = 0;
            } else {
                computer.team.get(cIndex).currentHealth -= damage;
            }
        }
        System.out.println("Your " + player.team.get(pIndex).getName() + " deals " + damage + " damage to the Enemy " + computer.team.get(cIndex).getName() + "!\n");
    }

    public void compTurn(int pIndex, int cIndex) {
        // Enemy's Turn
        int damage;
        tempStatsComp(pIndex, cIndex);
        System.out.print("Enemy " + computer.team.get(cIndex).getName() + "'s Attack: ");
        System.out.println("Base of " + computer.team.get(cIndex).getAttack() + " + Roll of " + attackRoll + " = " + computer.team.get(cIndex).tempAttack);
        System.out.print("Your " + player.team.get(pIndex).getName() + "'s Defense: ");
        System.out.println("Base of " + player.team.get(pIndex).getDefense() + " + Roll of " + defenseRoll + " = " + player.team.get(pIndex).tempDefense);
        if (computer.team.get(cIndex).tempAttack - player.team.get(pIndex).tempDefense <= 0) {
            damage = 0;
        } else {
            damage = computer.team.get(cIndex).tempAttack - player.team.get(pIndex).tempDefense;
            if (player.team.get(pIndex).currentHealth - damage < 0) {
                player.team.get(pIndex).currentHealth = 0;

            } else {
                player.team.get(pIndex).currentHealth -= damage;
            }
        }

        System.out.println("Enemy " + computer.team.get(cIndex).getName() + " deals " + damage + " damage to your " + player.team.get(pIndex).getName() + "!\n");

    }







}
