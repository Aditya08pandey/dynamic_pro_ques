//Using Space Optimized DP – O(m*n) Time and O(n) Space
import java.util.Arrays;

public class ShortestCommonSupersequence {
//     // C++ program to  find length of the
// // shortest supersequence using Using Space Optimized

//     static int shortestCommonSupersequence(String s1,
//                                            String s2) {
//         int m = s1.length();
//         int n = s2.length();

//         // Two 1D arrays to store only the
//         // current and previous rows
//         int[] prev = new int[n + 1];
//         int[] curr = new int[n + 1];

//         // Fill the first row (if s1 is empty,
//         // all characters of s2 are needed)
//         for (int j = 0; j <= n; j++)
//             prev[j] = j;

//         for (int i = 1; i <= m; i++) {

//             // Current row starts with i (if s2 is
//             // empty, all characters of s1 are needed)
//             curr[0] = i;

//             for (int j = 1; j <= n; j++) {

//                 // If characters match, add 1 to
//                 // the previous result
//                 if (s1.charAt(i - 1) == s2.charAt(j - 1))
//                     curr[j] = 1 + prev[j - 1];

//                 // If characters don't match, take the
//                 // minimum of the two possibilities
//                 else
//                     curr[j]
//                         = 1
//                           + Math.min(prev[j], curr[j - 1]);
//             }

//             // Move current row to previous for the
//             // next iteration
//             prev = curr.clone();
//         }

//         return prev[n];
//     }

//     public static void main(String[] args) {
//         String s1 = "AGGTAB";
//         String s2 = "GXTXAYB";
//         int res = shortestCommonSupersequence(s1, s2);
//         System.out.println(res);
//     }


// //==========================================================

//// Java program to  find length of the
// shortest supersequence using tabulation

    static int shortestCommonSupersequence(String s1,
                                           String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill table in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // Below steps follow above recurrence
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (s1.charAt(i - 1)
                         == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1
                               + Math.min(dp[i - 1][j],
                                          dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    public static void main(String args[]) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int res = shortestCommonSupersequence(s1, s2);
        System.out.println(res);
    }


}
