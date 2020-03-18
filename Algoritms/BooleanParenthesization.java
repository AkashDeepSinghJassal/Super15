/**
 * BooleanParenthesization No.of ways parenthesis can be to arrange to evaluate
 * problem true 
 * eg.. 
 * Input: symbol[] = {T, T, F, T} 
 * operator[] = {|, &, ^}
 * Output:
 * 4
 *  The given expression is "T | T & F ^ T", it evaluates true in 4 ways
 * ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
 * --------------------------------------
 * ALGIRITHM:
 * 1 - declare variables add base case 
 * 2 - using bottom up approach evaluate for 1....n terms 
 * 3 - test for all true and false count 
 * 4 - return true count of nth term.
 */
// for basics refer to Algo -> Matrix Chain Multiplication
public class BooleanParenthesization {
    static int CountParenthesis(char sym[], char op[]) {
        int n = sym.length;
        int T[][] = new int[n][n];
        int F[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            T[i][i] = (sym[i] == 'T') ? 1 : 0;
            F[i][i] = (sym[i] == 'F') ? 1 : 0;
        }
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                // calculate count for (i, j)
                int j = i + gap;
                for (int k = i; k < j; k++) {
                    // total count from i-k
                    int countIK = T[i][k] + F[i][k];
                    // total count form k+1 - j
                    int countKJ = T[k + 1][j] + F[k + 1][j];
                    int totalIJ = countIK * countKJ;
                    if (op[k] == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += totalIJ - T[i][k] * T[k + 1][j];
                    } else if (op[k] == '|') {
                        T[i][j] += totalIJ - F[i][k] * F[k + 1][j];
                        F[i][j] += F[i][k] * F[k + 1][j];
                    } else if (op[k] == '^') {
                        T[i][j] += T[i][k] * F[k + 1][j] + F[i][k] * T[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }
        return T[0][n - 1];
    }

    public static void main(String[] args) {
        char symbols[] = "TTFT".toCharArray();
        char operators[] = "|&^".toCharArray();
        System.out.println("Total Parenthesis Count :" + CountParenthesis(symbols, operators));
    }
}