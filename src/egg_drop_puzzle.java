//Egg Dropping Puzzle using space-optimized DP:

// Java program to find minimum number of trials in worst
// case.
import java.io.*;

class GFG {
    static int minTrials(int n, int k)
    {
        // Initialize array of size (n+1) and m as moves.
        int dp[] = new int[n + 1], m;
        for (m = 0; dp[n] < k; m++) {
            for (int x = n; x > 0; x--) {
                dp[x] += 1 + dp[x - 1];
            }
        }
        return m;
    }

    /* Driver code*/
    public static void main(String[] args)
    {
        int n = 2, k = 36;
        System.out.println("Minimum number of trials "
            + "in worst case with "
            + n + " eggs and " + k + " floors is " +
            minTrials(2, 36));
    }
}


//Time Complexity: O(N * K)
//Auxiliary Space: O(N)