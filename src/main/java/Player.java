import java.util.ArrayList;
import java.util.Random;

public class Player
{
    public ArrayList<Character> team =  new ArrayList<>(4);

    public void createTeam()
    {
        team.add(new CharacterList().pH);
        int charlistSize = new CharacterList().createCharList().size();

        for (int i = 1; i <= 3; i++) {
            team.add(new CharacterList().createCharList().get(new Random().nextInt(charlistSize)));
        }
    }

    public Character getChar(int charI)
    {
        return team.get(charI);
    }

    public void removeChar(int charI)
    {
        team.remove(charI);
        team.trimToSize();
    }

    public int teamSize()
    {
        return team.size() - 1;
    }
}
