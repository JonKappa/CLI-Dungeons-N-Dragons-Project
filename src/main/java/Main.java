import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    int t = 10;
    Main() {

    }
//    public static void color(int num) {
//        switch (num) {
//            case 1:
//                System.out.println("Red");
//            case 2:
//                System.out.println("Green");
//            case 3:
//                System.out.println("Blue");
//            default:
//                System.out.println("idk");
//        }
//    }
//    public static void lol(String a) {
//        System.out.println("Mess: " + a);
//    }


    public static void main(String[] args) {
//        int a = 5;
//        int b = 7;
//        int c = 12;
//        boolean r = a < c && b > a && c <= a || b > a;
        int num = 1;
        String s = null;
        try {
            num = s.length();
            num += 2;
        }
        catch (RuntimeException e) {
            num += 4;
        }
        System.out.println(num);
//        lol(String.valueOf(a));
    }
}
