import java.util.ArrayList;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Character Druid = new Druid();
        Character Orge = new Orge();
        Character Paladin = new Paladin();
        Character Rogue = new Rogue();
        Character Warrior = new Warrior();
        Character Wizard = new Wizard();

        ArrayList<Character>characters = new ArrayList<>(6);
        characters.add(Druid);
        characters.add(Orge);
        characters.add(Paladin);
        characters.add(Rogue);
        characters.add(Warrior);
        characters.add(Wizard);
        System.out.println(characters.get(new Random().nextInt(characters.size())));

        }




}
