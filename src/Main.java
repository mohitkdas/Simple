import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[][] a = {
                {1, -2, 3},
                {-4, -5, 6, 9},
                {7},
        };

//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[i].length; j++) {
//                System.out.println(a[i][j]);
//            }
//        }
//        Arrays.stream(a).forEach(b -> System.out.println(b));
//        Arrays.stream(a).forEach(row -> Arrays.stream(row).forEach(System.out::println));

        Arrays.stream(a).flatMapToInt(Arrays::stream).forEach(System.out::println);


    }
}