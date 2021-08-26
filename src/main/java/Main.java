import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game dnd = new Game();
        dnd.createCharList();
        dnd.createTeams();
        dnd.viewTeams();
        System.out.println("\nYour Turn!");
        System.out.println("Attackwith : ");

    }
}
