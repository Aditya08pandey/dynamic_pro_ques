import java.util.*;

public class minCostInMazeTravel {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int[][] dp= new int[n][m];

        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1; j>=0;j--){

                //last cell(no where to go)
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j]=arr[i][j];
                }
                //last row(only move horizontally forward)
                else if(i==dp.length-1){
                    dp[i][j]=dp[i][j+1]+arr[i][j];
                }
                //last column()
                else if(j==dp[0].length-1){
                    dp[i][j] = dp[i+1][j]+arr[i][j];
                }
                //any other cell
                else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+ arr[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
    
}



//==========================================================
//letcode -----------------
// class Solution {
//     public int minPathSum(int[][] arr) {

//         int n=arr.length;
//         int m=arr[0].length;
//         int dp[][]=new int[n][m];
//         for(int i=n-1;i>=0;i--){
//             for(int j=m-1;j>=0;j--){
//                 if(i==n-1 && j==m-1){
//                     dp[i][j]=arr[i][j];
//                 }
//                 else if(i==n-1){
//                     dp[i][j]=dp[i][j+1]+arr[i][j];
//                 }
//                 else if(j==m-1){
//                     dp[i][j]=dp[i+1][j]+arr[i][j];
//                 }
//                 else {
//                     dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+arr[i][j];
//                 }
//             }
//         }
//         return dp[0][0];
//     }
// }