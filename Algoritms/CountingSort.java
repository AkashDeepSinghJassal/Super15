import java.util.Arrays;
/**
 * CountingSort
 * ALGORITM:
 * 1 - variables
 *    -> arr[], count[], outputArr[], range , length
 * 2 - count frequency of each elemnt 
 *    ->index(0) relates to minimum and index(max - min) relates to maximum no.
 * 3 - modify count[] to store sum of previous elements
 * 4 - traverse input arr[] and assign value to output array at count index with decreasing count value by 1 
 */
public class CountingSort {

    public static void CountSort(int arr[]) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int outputArr[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < arr.length; i++) {
            outputArr[count[arr[i] - min] - 1] = arr[i];
            count[arr[0] - min]--;
        }
        // copying data back to orignal array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = outputArr[i];
        }
    }

    public static void Print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { -5, -10, 0, -3, 8, 5, -1, 10 };
        CountSort(arr);
        Print(arr);
    }
}