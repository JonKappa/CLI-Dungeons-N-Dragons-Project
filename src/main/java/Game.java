import java.util.Random;

public class Game
{
    public Player player = new Player();
    public Player computer = new Player();

    int attackRoll;
    int defenseRoll;

    public void createTeams() 
    {
        player.createTeam();
        computer.createTeam();
    }

    public void viewTeams()
    {
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

    public boolean isGameOver()
    {
        if (player.team.size() == 1) {
            viewTeams();
            System.out.println("The Enemy defeated all of your characters Computer wins!");
            return true;

        }
        
        if (computer.team.size() == 1) {
            viewTeams();
            System.out.println("You defeated all of the enemy's characters, you win!");
            return true;
        }
        
        return false;
    }


    public void tempStatsPlayer(int pIndex, int cIndex)
    {
        attackRoll = new Random().nextInt(6 + 1 - 1) + 1;
        defenseRoll = new Random().nextInt(6 + 1 - 1) + 1;
        player.team.get(pIndex).tempAttack = player.team.get(pIndex).getAttack() + attackRoll;
        computer.team.get(cIndex).tempDefense = computer.team.get(cIndex).getDefense() + defenseRoll;
    }
    public void tempStatsComp(int pIndex, int cIndex)
    {
        attackRoll = new Random().nextInt(6 + 1 - 1) + 1;
        defenseRoll = new Random().nextInt(6 + 1 - 1) + 1;
        computer.team.get(cIndex).tempAttack = computer.team.get(cIndex).getAttack() + attackRoll;
        player.team.get(pIndex).tempDefense = player.team.get(pIndex).getDefense() + defenseRoll;
    }
    public void playerTurn(int pI, int cI)
    {
        if (compareSpeed(pI, cI) == "Comp") {
            // if computer goes first

            System.out.println("Your " + player.team.get(pI).getName() + " counterattacks!");
        } else {
            // if player goes first

            System.out.println("Your " + player.team.get(pI).getName() + " goes first!");
        }

        // Player's attack
        int damage;
        tempStatsPlayer(pI, cI);

        System.out.print("Your " + player.team.get(pI).getName() + "'s Attack: ");
        System.out.println("Base of " + player.team.get(pI).getAttack() + " + Roll of " + attackRoll + " = " + player.team.get(pI).tempAttack);

        System.out.print("Enemy " + computer.team.get(cI).getName() + "'s Defense: ");
        System.out.println("Base of " + computer.team.get(cI).getDefense() + " + Roll of " + defenseRoll + " = " + computer.team.get(cI).tempDefense);

        damage = player.team.get(pI).tempAttack - computer.team.get(cI).tempDefense;

        if (damage < 0) {
            damage = 0;
        }

        computer.team.get(cI).currentHealth -= damage;

        System.out.println("Your " + player.team.get(pI).getName() + " deals " + damage + " damage to the Enemy " + computer.team.get(cI).getName() + "!\n");

        if (computer.team.get(cI).currentHealth <= 0) {
            computer.removeChar(cI);
            return;
        }

        if (compareSpeed(pI, cI) == "Player") {
            compTurn(pI, cI);
        }
    }

    public void compTurn(int pI, int cI)
    {
        if (compareSpeed(pI, cI) == "Player") {
            // if player goes first
            System.out.println("Enemy " + computer.team.get(cI).getName() + " counterattacks!");
        } else {
            System.out.println("Enemy " + computer.team.get(cI).getName() + " goes first!");
        }

        // Enemy's Turn
        int damage;
        tempStatsComp(pI, cI);

        System.out.print("Enemy " + computer.team.get(cI).getName() + "'s Attack: ");
        System.out.println("Base of " + computer.team.get(cI).getAttack() + " + Roll of " + attackRoll + " = " + computer.team.get(cI).tempAttack);

        System.out.print("Your " + player.team.get(pI).getName() + "'s Defense: ");
        System.out.println("Base of " + player.team.get(pI).getDefense() + " + Roll of " + defenseRoll + " = " + player.team.get(pI).tempDefense);

        damage = computer.team.get(cI).tempAttack - player.team.get(pI).tempDefense;

        if (damage < 0) {
            damage = 0;
        }

        player.team.get(pI).currentHealth -= damage;

        System.out.println("Enemy " + computer.team.get(cI).getName() + " deals " + damage + " damage to your " + player.team.get(pI).getName() + "!\n");

        if (player.team.get(pI).currentHealth <= 0) {
            player.removeChar(pI);
            return;
        }

        if (compareSpeed(pI, cI) == "Comp") {
            playerTurn(pI, cI);
        }
    }

    public String compareSpeed(int pI, int cI)
    {
        return player.team.get(pI).getSpeed() >= computer.team.get(cI).getSpeed() ? "Player" : "Comp";
    }

    public void sleep(int milTime)
    {
        try {
            Thread.sleep(milTime);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public void clear()
    {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
