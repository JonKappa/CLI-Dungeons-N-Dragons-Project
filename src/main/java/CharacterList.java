import java.util.ArrayList;

public class CharacterList
{
    Character Druid = new Druid();
    Character Orge = new Orge();
    Character Paladin = new Paladin();
    Character Rogue = new Rogue();
    Character Warrior = new Warrior();
    Character Wizard = new Wizard();
    Character pH = new Character("null", 0, 0, 0, 0, 0);

    ArrayList<Character> charList = new ArrayList<>(6);

    public ArrayList<Character> createCharList()
    {
        charList.add(Druid);
        charList.add(Orge);
        charList.add(Paladin);
        charList.add(Rogue);
        charList.add(Warrior);
        charList.add(Wizard);

        return charList;
    }
}
