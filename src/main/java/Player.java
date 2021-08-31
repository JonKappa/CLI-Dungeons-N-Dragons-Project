import java.util.ArrayList;
import java.util.Random;

public class Player {
    ArrayList<Character> team =  new ArrayList<>(3);
    public void createTeam() {
        CharacterList characterList1  = new CharacterList();
        CharacterList characterList2  = new CharacterList();
        CharacterList characterList3  = new CharacterList();
        team.add(characterList1.pH);
        characterList1.createCharList();
        characterList2.createCharList();
        characterList3.createCharList();
        team.add(characterList1.charList.get(new Random().nextInt(characterList1.charList.size())));
        team.add(characterList2.charList.get(new Random().nextInt(characterList1.charList.size())));
        team.add(characterList3.charList.get(new Random().nextInt(characterList1.charList.size())));
    }


}
