package sort;

import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] integers = new int[N];

        for(int i = 0; i < integers.length; i++) {
            integers[i] = sc.nextInt();
        }

//        selectionSort(integers, N);
//        bubbleSort(integers, N);
//        insertionSort(integers, N);
//        mergeSort(integers, 0, N-1);
        quickSort(integers, 0, N-1);

        System.out.println();
        for(int i : integers) {
            System.out.print(i + " ");
        }
    }

    private static void selectionSort(int[] integers, int n) {
        for(int i = 0; i < n - 1; i++) {
            int mini = i;

            for(int j = i; j < n; j++)
                if(integers[j] < integers[mini]) mini = j;

            swap(integers, i, mini);
        }
    }

    private static void bubbleSort(int[] arr, int n) {
        boolean didSwap = false;
        for(int i = n - 1; i > 0; i--) {

            for(int j = 0; j < i; j++)

                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    didSwap = true;
                }

            if (!didSwap) break;
        }
    }

    private static void insertionSort(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]) {
                swap(arr, j-1, j);
                j--;
            }
        }
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid+1;

        int i = 0;
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp[i] = arr[left];
                left++;
            } else {
                temp[i] = arr[right];
                right++;
            }
            i++;
        }

        while(left <= mid) {
            temp[i] = arr[left];
            left++;
            i++;
        }

        while(right <= high) {
            temp[i] = arr[right];
            right++;
            i++;
        }

        for(int j = low; j <= high; j++) {
            arr[j] = temp[j - low];
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while(arr[i] <= pivot && i <= high-1) i++;

            while(arr[j] > pivot && j >= low+1) j--;

            if (i < j) swap(arr, i, j);

        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] integers, int i, int mini) {
        int temp = integers[mini];
        integers[mini] = integers[i];
        integers[i] = temp;
    }
}
