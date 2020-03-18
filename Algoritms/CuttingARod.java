/**
 * CuttingARod
 */
public class CuttingARod {

    // initially this solution has exponential complexity and can be readuced by
    // optimal substructure using dynamic programming
    // Optimum solution:
    // 1 - taking varibale priceLength -> stores max value of specific length
    // 2 - if priceLength != 0 return it else calculate max value of length store it
    // Complexity O(n ^ 2)
    static int priceLength[];

    static int MaximumPriceTopBottom(int p[], int n) {
        if (n == 0) {
            return 0;
        }
        if (priceLength[n] != 0) {
            return priceLength[n];
        }
        int max = 0;
        for (int i = n; i > 0; i--) {
            int price = p[i - 1];
            price += MaximumPriceTopBottom(p, n - i);
            if (max < price) {
                max = price;
            }
        }
        priceLength[n] = max;
        return max;
    }
    // Non recurrsive optimal solution 
    static int MaximumPriceBottomsUp(int p[]){
        // priceLength stores max value of specific length
        // 1 - starting from 1 to n we will calculate max value per specific length
        // 2 - return nth max value length
        int n= p.length;
        int priceLength[] = new int [n + 1];
        // n == 0 will have 0 value
        priceLength[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxValue = 0;
            for (int j = 0; j < i; j++) {
                maxValue = Math.max(maxValue, p[j] + priceLength[i - 1 - j]);
            }
            // stores maximum value for length
            priceLength[i] = maxValue;
        }
        // maximum value of nth length long rod
        return priceLength[n];
    }

    public static void main(String[] args) {
        int priceArr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int length = priceArr.length;
        priceLength = new int[length + 1];
        System.out.println("Maximum value by cutting rod (Recurrsive): " + MaximumPriceTopBottom(priceArr, length));
        System.out.println("Maximum value by cutting rod (NON Recurrsive): " + MaximumPriceBottomsUp(priceArr));
    }
}