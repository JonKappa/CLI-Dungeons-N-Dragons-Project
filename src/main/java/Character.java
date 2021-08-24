public class Character {

    int health;
    int attack;
    int defense;
    int speed;
    int tempPlayerAttack;
    int tempCompDefense;


    public Character(){
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }
    public void playerAttackTurn(){
        if(player.getSpeed > computer.getSpeed){
            tempPlayerAttack += attack;
        }
    }
    public void computerAttackTurn(){
        if (computer.getSpeed > player.getSpeed){
            te
        }

    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

}
