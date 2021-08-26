import java.util.ArrayList;
import java.util.Random;

public class Game {
    Character Druid = new Druid();
    Character Orge = new Orge();
    Character Paladin = new Paladin();
    Character Rogue = new Rogue();
    Character Warrior = new Warrior();
    Character Wizard = new Wizard();
    Character pH = new Character("null", 0, 0, 0, 0, 0);
    ArrayList<Character> characterList = new ArrayList<>(6);
    ArrayList<Character> playerTeam =  new ArrayList<>(3);
    ArrayList<Character> computerTeam = new ArrayList<>(3);
    int attackRoll;
    int defenseRoll;

    public void createCharList(){
        characterList.add(Druid);
        characterList.add(Orge);
        characterList.add(Paladin);
        characterList.add(Rogue);
        characterList.add(Warrior);
        characterList.add(Wizard);
        playerTeam.add(pH);
        computerTeam.add(pH);
    }

    public void createTeams() {
        for (int i = 0; i < 3; i++) {
            playerTeam.add(characterList.get(new Random().nextInt(characterList.size())));
            computerTeam.add(characterList.get(new Random().nextInt(characterList.size())));
        }
    }

    public void viewTeams() {
        StringBuilder chars = new StringBuilder();

        chars.append("Your Team\n");
        chars.append("--------------------------------------------------------------------\n");
        chars.append(String.format("%-24s%-24s%-24s\n",
                playerTeam.get(1).name + " (1)",
                playerTeam.get(2).name + " (2)",
                playerTeam.get(3).name + " (3)"));
        chars.append(String.format("%-24s%-24s%-24s\n%-24s%-24s%-24s\n%-24s%-24s%-24s\n%-24s%-24s%-24s\n\n",
                " - Health: "+playerTeam.get(1).getCurrentHealth()+" / "+playerTeam.get(1).getMaxHealth(),
                " - Health: "+playerTeam.get(2).getCurrentHealth()+" / "+playerTeam.get(2).getMaxHealth(),
                " - Health: "+playerTeam.get(3).getCurrentHealth()+" / "+playerTeam.get(3).getMaxHealth(),
                " - Attack: " + playerTeam.get(1).getAttack(),
                " - Attack: " + playerTeam.get(2).getAttack(),
                " - Attack: " + playerTeam.get(3).getAttack(),
                " - Defense: " + playerTeam.get(1).getDefense(),
                " - Defense: " + playerTeam.get(2).getDefense(),
                " - Defense: " + playerTeam.get(3).getDefense(),
                " - Speed: " + playerTeam.get(1).getSpeed(),
                " - Speed: " + playerTeam.get(2).getSpeed(),
                " - Speed: " + playerTeam.get(3).getSpeed()));

        chars.append("Enemy Team\n");
        chars.append("--------------------------------------------------------------------\n");
        chars.append(String.format("%-24s%-24s%-24s\n",
                computerTeam.get(1).name + " (1)",
                computerTeam.get(2).name + " (2)",
                computerTeam.get(3).name + " (3)"));
        chars.append(String.format("%-24s%-24s%-24s\n%-24s%-24s%-24s\n%-24s%-24s%-24s\n%-24s%-24s%-24s\n",
                " - Health: "+computerTeam.get(1).getCurrentHealth()+" / "+computerTeam.get(1).getMaxHealth(),
                " - Health: "+computerTeam.get(2).getCurrentHealth()+" / "+computerTeam.get(2).getMaxHealth(),
                " - Health: "+computerTeam.get(3).getCurrentHealth()+" / "+computerTeam.get(3).getMaxHealth(),
                " - Attack: " + computerTeam.get(1).getAttack(),
                " - Attack: " + computerTeam.get(2).getAttack(),
                " - Attack: " + computerTeam.get(3).getAttack(),
                " - Defense: " + computerTeam.get(1).getDefense(),
                " - Defense: " + computerTeam.get(2).getDefense(),
                " - Defense: " + computerTeam.get(3).getDefense(),
                " - Speed: " + computerTeam.get(1).getSpeed(),
                " - Speed: " + computerTeam.get(2).getSpeed(),
                " - Speed: " + computerTeam.get(3).getSpeed()));

        System.out.println(chars);
        for (int i = 1; i < playerTeam.size(); i++){
            if (playerTeam.get(i).getCurrentHealth() <= 0) {

            }
        }
        for (int i = 1; i < computerTeam.size(); i++){
            if (playerTeam.get(i).getCurrentHealth() <= 0) {

            }
        }
    }


    public void tempStatsPlayer(int pIndex, int cIndex) {
        attackRoll = new Random().nextInt(7);
        defenseRoll = new Random().nextInt(7);
        playerTeam.get(pIndex).tempAttack = playerTeam.get(pIndex).getAttack() + attackRoll;
        computerTeam.get(cIndex).tempDefense = computerTeam.get(cIndex).getDefense() + defenseRoll;
    }
    public void tempStatsComp(int pIndex, int cIndex) {
        attackRoll = new Random().nextInt(7);
        defenseRoll = new Random().nextInt(7);
        computerTeam.get(pIndex).tempAttack = computerTeam.get(pIndex).getAttack() + attackRoll;
        playerTeam.get(pIndex).tempDefense = playerTeam.get(pIndex).getDefense() + defenseRoll;
    }
    public void playerTurn(int pIndex, int cIndex) {
        int damage;
        if (playerTeam.get(pIndex).getSpeed() >= computerTeam.get(cIndex).getSpeed()) {
            // Player's attack if Player goes first
            tempStatsPlayer(pIndex, cIndex);
            System.out.println("Your "+playerTeam.get(cIndex).getName() + " goes first!");
            System.out.print("Your " + playerTeam.get(pIndex).getName() + "'s Attack: ");
            System.out.println("Base of "+playerTeam.get(pIndex).getAttack()+" + Roll of "+attackRoll+" = "+playerTeam.get(pIndex).tempAttack);
            System.out.print("Enemy "+computerTeam.get(cIndex).getName()+" 's Defense: ");
            System.out.println("Base of "+computerTeam.get(cIndex).getDefense()+" + Roll of "+defenseRoll+" = "+computerTeam.get(cIndex).tempDefense);
            if (playerTeam.get(pIndex).tempAttack - computerTeam.get(cIndex).tempDefense <= 0) {
                damage = 0;
            }
            else{
                damage = playerTeam.get(pIndex).tempAttack - computerTeam.get(cIndex).tempDefense;
                computerTeam.get(cIndex).currentHealth -= damage;
            }
            System.out.println("Your "+playerTeam.get(cIndex).getName()+" deals "+damage+" damage to the Enemy "+computerTeam.get(cIndex).getName()+"!\n");
            // Enemy's CounterAttack if Player goes first
            tempStatsComp(pIndex, cIndex);
            System.out.println("Enemy "+computerTeam.get(cIndex).getName()+" counterattacks!");
            System.out.print("Enemy " + computerTeam.get(cIndex).getName() + "'s Attack: ");
            System.out.println("Base of "+computerTeam.get(cIndex).getAttack()+" + Roll of "+attackRoll+" = "+computerTeam.get(cIndex).tempAttack);
            System.out.print("Your "+playerTeam.get(pIndex).getName()+" 's Defense: ");
            System.out.println("Base of "+playerTeam.get(pIndex).getDefense()+" + Roll of "+defenseRoll+" = "+playerTeam.get(pIndex).tempDefense);
            if (computerTeam.get(cIndex).tempAttack - playerTeam.get(pIndex).tempDefense <= 0) {
                damage = 0;
            }
            else{
                damage = computerTeam.get(cIndex).tempAttack - playerTeam.get(pIndex).tempDefense;
                playerTeam.get(pIndex).currentHealth-= damage;
            }
        }
        else {
            tempStatsComp(pIndex, cIndex);
            System.out.println("Enemy's "+computerTeam.get(cIndex).getName() + " goes first!");
            System.out.println("Base of " + computerTeam.get(cIndex).getAttack() + " + Role of " + attackRoll + " = " + computerTeam.get(cIndex).tempAttack);
        }

    }







}
