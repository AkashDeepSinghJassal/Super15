/**
 * TilingProblem
 * For 2 * n area count no of ways to tile complete area using 2 * 1 tile
 * ALGORITHM ( nth Fibonacci Series ):
 * 1 - Use naive recurrsion approach to find count(n)
 *   -> if(vertical tile) then count(n - 1)
 *   -> if(horizontal tile) then count (n - 2)
 * Equation count(n) = count(n-1) + count(n-2)
 * This solution can be optimised by dynamic programming
 * storing calcualted subproblem
 * 2 Base condition
 *   -> if (n== 0) static countTile++;
 */
public class TilingProblem {

    static int count(int n){
        int tileCount[] = new int[n + 1];
        // base cases
        tileCount[1] = 1;
        // for 2 * n(n==2) two vertical or two horizontal (count = 2)
        tileCount[2] = 2;
        for (int i = 3; i <= n; i++) {
            tileCount[i] = tileCount[i-1] + tileCount[i - 2];
        }
        return tileCount[n] ;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println("No of ways to tile : "+ count(n));
    }
}