import java.util.Arrays;
import java.util.stream.Collectors;

public class Organise {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,2,1,1,2,1,2,1,1};
//        selectionSort(arr, arr.length);

        Arrays.stream(arr).sorted().forEach(x -> System.out.print(x + " "));

        System.out.println();
        String s = "My Name Is Mohit";
        String reverse = Arrays.stream(s.split(" ")).reduce((o1, o2) -> o2 + " " +o1).get();
        String test = Arrays.stream(s.split(" ")).map(x -> new StringBuilder(x).reverse()).collect(Collectors.joining(" "));
        System.out.println(test);
        System.out.println(reverse);

    }

    private static void selectionSort(int[] arr, int n) {
        for(int i = 0; i < n-1; i++) {
            int mini = i;
            for(int j = i; j < n; j++) {
                if(arr[j] < arr[mini]) mini = j;
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
