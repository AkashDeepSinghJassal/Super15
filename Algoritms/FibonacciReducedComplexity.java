/**
 * FibonacciReducedComplexity
 * ALGORITHM:
 * {1, 1}^n = {Fn+1, Fn}
 * {1, 0}     {Fn, Fn-1}
 * Using matrix multiplication for power n Fobonacci nth term can be calcualted
 * For even n : F * F is only calculated
 * For odd  n : F * F and F * M is claculated 
 * eg 5/2 = 2 so additional multiply by M
 *    4/2 = 2 
 */
public class FibonacciReducedComplexity {

    static int M[][] = { { 1, 1 }, { 1, 0 } };

    static int FibonacciNthTerm_OLog2n(int n) {
        int F[][] = { { 1, 1 }, { 1, 0 } };
        power(F, n - 1);
        return F[0][0];
    }

    static void power(int F[][], int n) {
        if (n == 0 || n == 1) {
            return;
        }
        power(F, n / 2);
        multiply(F, F);
        if (n % 2 == 1) {
            multiply(F, M);
        }
    }

    static void multiply(int F[][], int M[][]){
        int a = F[0][0]*M[0][0] + F[0][1]* M[1][0];
        int b = F[0][0]*M[0][1] + F[0][1]* M[1][1];
        int c = F[1][0]*M[0][0] + F[1][1]* M[1][0];
        int d = F[1][0]*M[0][1] + F[1][1]* M[1][1];
        F[0][0] = a;
        F[0][1] = b;
        F[1][0] = c;
        F[1][1] = d;
    }
    static int FibonacciNthTerm_O1(int n){
        double x = (Math.sqrt(5) + 1)/2;
        return (int)Math.round(Math.pow(x, n)/ Math.sqrt(5));
    }
    public static void main(String[] args) {
        int n = 8;
        System.out.println("Fibonacci Nth term O(log2n) : " + FibonacciNthTerm_OLog2n(n));
        System.out.println("Fibonacci Nth term O(1) : " + FibonacciNthTerm_O1(n));
    }
}