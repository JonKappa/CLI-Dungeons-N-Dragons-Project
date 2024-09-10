import java.util.Random;

public class Game
{
    public Player player = new Player();
    public Player computer = new Player();

    int pIndex;
    int cIndex;

    int attackRoll;
    int defenseRoll;
    boolean counterAttack = false;

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
        if (player.teamSize() == 0) {
            clear();
            viewTeams();

            System.out.println("The Enemy defeated all of your characters, Computer wins!");

            return true;

        }
        
        if (computer.teamSize() == 0) {
            clear();
            viewTeams();

            System.out.println("You defeated all of the enemy's characters, Player win!");

            return true;
        }
        
        return false;
    }


    public void tempStatsPlayer(Character playerChar, Character computerChar)
    {
        attackRoll = new Random().nextInt(6 + 1 - 1) + 1;
        defenseRoll = new Random().nextInt(6 + 1 - 1) + 1;
        playerChar.tempAttack = playerChar.getAttack() + attackRoll;
        computerChar.tempDefense = computerChar.getDefense() + defenseRoll;
    }

    public void tempStatsComp(Character computerChar, Character playerChar)
    {
        attackRoll = new Random().nextInt(6 + 1 - 1) + 1;
        defenseRoll = new Random().nextInt(6 + 1 - 1) + 1;
        computerChar.tempAttack = computerChar.getAttack() + attackRoll;
        playerChar.tempDefense = playerChar.getDefense() + defenseRoll;
    }

    public void playerTurn(Character playerChar, Character computerChar)
    {
        if (counterAttack) { // if computer goes first
            System.out.println("Your " + playerChar.getName() + " counterattacks!");
        } else { // if player goes first
            System.out.println("Your " + playerChar.getName() + " goes first!");
        }

        // Player's attack
        int damage;
        tempStatsPlayer(playerChar, computerChar);

        System.out.print("Your " + playerChar.getName() + "'s Attack: ");
        System.out.println("Base of " + playerChar.getAttack() + " + Roll of " + attackRoll + " = " + playerChar.tempAttack);

        System.out.print("Enemy " + computerChar.getName() + "'s Defense: ");
        System.out.println("Base of " + computerChar.getDefense() + " + Roll of " + defenseRoll + " = " + computerChar.tempDefense);

        damage = playerChar.tempAttack - computerChar.tempDefense;

        if (damage <= 0) {
            damage = 1;
        }

        computerChar.currentHealth -= damage;

        System.out.println("Your " + playerChar.getName() + " deals " + damage + " damage to the Enemy " + computerChar.getName() + "!\n");

        if (computerChar.currentHealth <= 0) {
            computer.removeChar(cIndex);
            return;
        }

        System.out.println(counterAttack);
        if (! counterAttack) {
            counterAttack = true;
            compTurn(computerChar, playerChar);
        }
    }

    public void compTurn(Character computerChar, Character playerChar)
    {
        if (counterAttack) { // if player goes first
            System.out.println("Enemy " + computerChar.getName() + " counterattacks!");
        } else { // if computer goes first
            System.out.println("Enemy " + computerChar.getName() + " goes first!");
        }

        // Enemy's Turn
        int damage;
        tempStatsComp(computerChar, playerChar);

        System.out.print("Enemy " + computerChar.getName() + "'s Attack: ");
        System.out.println("Base of " + computerChar.getAttack() + " + Roll of " + attackRoll + " = " + computerChar.tempAttack);

        System.out.print("Your " + playerChar.getName() + "'s Defense: ");
        System.out.println("Base of " + playerChar.getDefense() + " + Roll of " + defenseRoll + " = " + playerChar.tempDefense);

        damage = computerChar.tempAttack - playerChar.tempDefense;

        if (damage <= 0) {
            damage = 1;
        }

        playerChar.currentHealth -= damage;

        System.out.println("Enemy " + computerChar.getName() + " deals " + damage + " damage to your " + playerChar.getName() + "!\n");

        if (playerChar.currentHealth <= 0) {
            player.removeChar(pIndex);
            return;
        }

        System.out.println(counterAttack);
        if (! counterAttack) {
            counterAttack = true;
            playerTurn(playerChar, computerChar);
        }
    }

    /**
     * Compare two speeds.
     * 
     * <p>Returns true if char1's speed is larger or the same. 
     * <p>Returns false if char2's speed is larger.
     *
     * @param char1 character 1
     * @param char2 character 2
     * 
     * @return boolean
     */
    public boolean compareSpeed(Character char1, Character char2)
    {
        if (char1.getSpeed() == char2.getSpeed()) {
            return new Random().nextBoolean();
        }

        return char1.getSpeed() > char2.getSpeed();
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
