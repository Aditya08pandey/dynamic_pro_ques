public class knapsack{

    //function definition
    //recursive approach
    //t.c: O(2^N) - Exponential time complexity
    //s.c = O(n)

    // 0/1 knapsack problem

    public static int knapSack(int m, int[] profit, int[] weight, int n){
        //base case
        if(m==0 || n==0){
            return 0;

        }

        //recursive function call
        if(weight[n-1]>m){
            //exclude object
            return knapSack(m, profit, weight, n-1);
        }

        else{
            //max(either exclude the object or include the oblect)
            return Math.max(knapSack(m, profit, weight, n-1), profit[n-1] + knapSack(m-weight[n-1], profit, weight, n-1) );
        }
    }


    //Memoization method => D.P method
    //t.c= O(n*m)
    //s.c= O(n*m)

    //function definition of memoization approach in dp
    public static int knapSackMemo(int m,int[] profit, int[] weight, int n, int[][] dp){
             //base case
        if(m==0 || n==0){
            return 0;

        }

        //optimization - avoid recomputation of recursive function call

        //recursive function call
        if(weight[n-1]>m){
            //exclude object
            return dp[n][m]= knapSack(m, profit, weight, n-1);
        }

        else{
            //max(either exclude the object or include the oblect)
            return dp[n][m] = Math.max(knapSack(m, profit, weight, n-1), profit[n-1] + knapSack(m-weight[n-1], profit, weight, n-1) );
        }
    }
    //Helper function of memoization method

    public static int helper(int m, int[] profit, int[] weight, int n){
        //initialisation of 2d array
        int dp[][] = new int[n+1][m+1];

        //initialisation of 2d array with -1;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j] = -1;
            }
        }

        return knapSackMemo(m,profit,weight,n,dp);
    }

    //Tabulation method = no recursion
    //time and space complexity is same as above

    public static int knapSackTabu(int m, int[] profit, int[] weight, int n) {
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int w=0;w<=m;w++){
                if(i == 0 || w == 0){
                   dp[i][w]=0;
                }
                else if(weight[i-1] <= w){
                    dp[i][w]= Math.max(dp[i-1][w], profit[i-1] + dp[i-1][w-weight[i-1]]);
                }
                else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[n][m];
        
    }
    public static void main(String[] args) {
        int[] profit={60,100,120};
        int[] weight={10,20,30};

        int m=50;
        int n=profit.length;

        System.out.println("Max profit of the given knapsack is: " + knapSackTabu(m, profit, weight, n) );
    }
}
