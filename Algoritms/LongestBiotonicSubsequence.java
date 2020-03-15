/**
 * LongestBiotonicSubsequence
 * ALGORITHM:
 * 1 - find longest decreasing subsequenece
 * 2 - find longest increasing subsequence and correspondly find maximum length (lis + lds) 
 * 3 - varibales 
 *   -> lis[] (longest increasing sub.) , lds[] (longest decreasing sub.)
 *   -> max length
 */
public class LongestBiotonicSubsequence {

    public static int lbs(int arr[]) {
        int n = arr.length;
        int lis[] = new int[n];
        int lds[] = new int[n];
        // calculating lds
        for (int i = 0; i < arr.length; i++) {
            // initializing every index to length 1
            lds[i] = 1;
            lis[i] = 1;
        }
        int maxLbs = 1;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i] && lds[j] >= lds[i]) {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        // calculating lis
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lis[j] >= lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
            // maximum - total biotonic length
            if (maxLbs < lds[i] + lis[i] - 1) {
                maxLbs = lds[i] + lis[i] - 1;
            }
        }
        return maxLbs;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        System.out.println("Longest Biotonic Subsequence : " + lbs(arr));
    }
}