import java.util.ArrayList;
import java.util.Random;

public class Player
{
    public ArrayList<Character> team =  new ArrayList<>(4);

    public void createTeam()
    {
        CharacterList characterList  = new CharacterList();

        team.add(characterList.pH);
        characterList.createCharList();

        team.add(characterList.charList.get(new Random().nextInt(characterList.charList.size())));
        team.add(characterList.charList.get(new Random().nextInt(characterList.charList.size())));
        team.add(characterList.charList.get(new Random().nextInt(characterList.charList.size())));
    }

    public void removeChar(int charI)
    {
        team.remove(charI);
        team.trimToSize();
    }
}
