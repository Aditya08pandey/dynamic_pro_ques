import java.util.*;

//Space optimized Approach – O(n x W) Time and O(W) Space
// Java program for the above approach

public class knapsack_01 {
    
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // Making and initializing dp array
        int[] dp = new int[W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {

                if (wt[i - 1] <= w)

                    // Finding the maximum value
                    dp[w]
                        = Math.max(dp[w], dp[w - wt[i - 1]]
                                              + val[i - 1]);
            }
        }
        // Returning the maximum value of knapsack
        return dp[W];
    }

    // Driver code
    public static void main(String[] args)
    {
        int profit[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.print(knapSack(W, weight, profit, n));
    }

}

//==============================================================================================================

//Tabulation or Bottom-Up Approach – O(n x W) Time and Space

// import java.util.Arrays;

// public class Knapsack{
  
//     // Returns the value of maximum profit
//     public static int kSackRec(int W, int[] wt, int[] val, int index, int[][] memo) {
      
//         // Base condition
//         if (index < 0)
//             return 0;

//         if (memo[index][W] != -1)
//             return memo[index][W];

//         // Store the value in the table before return
//         if (wt[index] > W) {
//             memo[index][W] = kSackRec(W, wt, val, index - 1, memo);
//         } else {
//             memo[index][W] = Math.max(val[index] + kSackRec(W - wt[index], wt, val, index - 1, memo),
//                                        kSackRec(W, wt, val, index - 1, memo));
//         }

//         return memo[index][W];
//     }

//     public static int kSack(int W, int[] wt, int[] val) {
//         int n = wt.length;
//         int[][] memo = new int[n][W + 1];
//         for (int[] row : memo) {
//             Arrays.fill(row, -1);
//         }
//         return kSackRec(W, wt, val, n - 1, memo);
//     }

//     // Driver Code
//     public static void main(String[] args) {
//         int[] profit = {60, 100, 120};
//         int[] weight = {10, 20, 30};
//         int W = 50;
//         System.out.println(kSack(W, weight, profit));
//     }
// }