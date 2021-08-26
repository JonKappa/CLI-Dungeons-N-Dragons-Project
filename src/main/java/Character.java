public class Character {

    final String name;
    int currentHealth;
    final int maxHealth;
    final int attack;
    final int defense;
    final int speed;
    int tempAttack;
    int tempDefense;



    public Character(String name, int currentHealth, int maxHealth, int attack, int defense, int speed){
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }
//    public void playerAttackTurn(){
//        if(player.getSpeed > computer.getSpeed){
//            tempPlayerAttack += attack;
//        }
//    }
//    public void computerAttackTurn(){
//        if (computer.getSpeed > player.getSpeed){
//
//        }

//    }
    public String getName() {return name;}

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {return currentHealth;}

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }


    public String toString() {
        return getClass().getName() + "" + "\n" +
                " - Health: " + currentHealth + " / " + maxHealth + "\n" +
                " - Attack: " + attack + "\n" +
                " - Defense: " + defense + "\n" +
                " - Speed: " + speed;
    }
}
