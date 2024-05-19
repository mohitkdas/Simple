import java.util.Arrays;

public class PassByValue {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);
        changeValue(a);
        System.out.println(a);

        int[] arr = {1, 2, 3, 4, 5};
        Arrays.stream(arr).forEach(System.out::println);
        changeArr(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void changeArr(int[] brr) {
        brr[0] = 10;
        //print the array
        Arrays.stream(brr).forEach(System.out::println);
    }

    private static void changeValue(int b) {
        System.out.println(++b);
    }
}
