/**
 * MaximumSequenceCollatzConjecture
 * Given n terms find i'th term with maximum sequence
 * ALGORTIRM:
 * 1 - Use Dynamic programming to store solutions for nth sequences 
 * 2 - varibale -> collatzArr[] 
 * 3 - base condition -> collatzArr[1] = 1
 * 3 - print maximum value of collatz conjecture
 */
public class MaximumSequenceCollatzConjecture {

    static int collatzArr[];
    static int maxSeqCollatzIndex(int n){
        int maxIndex = 0;
        int maxVal = -1;
        for (int i = 2; i <= n; i++) {
            int val = maxCollatzValue(i);
            if(maxVal < val){
                maxVal = val;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    static int maxCollatzValue(int n){
        int orig = n;
        int len = 0;
        // it mean collatzArr[n] ==0 has no value calculated and keep on calculating
        while(collatzArr[n] == 0){
            n = (n % 2 == 0)?n/2:n*3 +1;
            len++;
        }
        collatzArr[orig] = len + collatzArr[n];
        return collatzArr[orig];
    }
    public static void main(String[] args) {
        int n = 100;
        collatzArr = new int [1000000];
        collatzArr[1] = 1;
        int index = maxSeqCollatzIndex(n);
        System.out.println("("+index+", "+collatzArr[index]+")");
    }
}