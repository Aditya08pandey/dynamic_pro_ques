import java.util.Scanner;

public class climbingStairs {


        //public static Map<Integer,Integer> memo = new HashMap<>();
        // public int climbStairs(int n) {
            
    
            //TLE---------------
            //Recursion Approach
            // if(n==1 || n==2){
            // return n;
            // }
            // else{
            // return climbStairs(n-1)+ climbStairs(n-2);
            // }
    
         
            //Memoization approach--D.P
            //t.c= s.c = O(n)
    
            // if(n==1 || n==2){
            //  return n;
            // }
    
            // //avoid the re-computations
            // if(memo.containsKey(n)){
            //    return memo.get(n);
            // }
    
            // //recursive function call
            // int numways = climbStairs(n-1) + climbStairs(n-2);
    
            // //insert in map
            // memo.put(n,numways);
            // return numways;
    
            //Tabulation method--dynamic programming
            // t.c and s.c = O(N)
    
            // if(n==1){
            //     return 1;
            // }
    
            // //array initilasition
            // int [] cs = new int[n+1];
            // cs[1]=1;
            // cs[2]=2;
    
            // for(int i=3;i<=n;i++){
            //     cs[i]=cs[i-1]+cs[i-2];
            // }
            // return cs[n];
    
            //Most optimized method
    
        //     if(n==1){
        //         return 1;
        //     }
    
        //     int first=1, second=2, third;
    
        //     for(int i=3;i<=n;i++){
        //         third=first+second;
        //         first=second;
        //         second=third;
    
        //     }
        //     return second;
    
        // }


        //Q2=>CLIMBING STAIRS WITH VARIABLE JUMPS==============================================
        //n=Number of stairs and we stand at 0 position
        //You are given n numbers, where ith element value represent till how far from the steps you can jump to in a single move
        //Tabulation method
        // public static void main(String[] args) {
        //     Scanner sc=new Scanner(System.in);
        //     int n=sc.nextInt();

        //     int[] arr=new int[n];
        //     for(int i=0;i<arr.length;i++){
        //         arr[i]=sc.nextInt();
        //     }

        //     int dp[]= new int[n+1];
        //     dp[n]=1; //at last stair there is only one way i.e stand still

        //     for(int i=n-1;i>=0;i--){
        //         for(int j=1;j<=arr.length && i+j<dp.length ;j++){
        //             dp[i] += dp[i+j];
        //         }
                
        //     }
        //     System.out.println(dp[0]);
        // }
    

        //Q3=> Climbing stairs with minimum jumps---------------------------------

        //n=Number of stairs and we stand at 0 position
        //You are given n numbers, where ith element value represent till how far from the steps you can jump to in a single move
        //if there is no way then return null
        //Minimum moves requires to climb at the top 
        //Tabulation method

        //we use INT for making array as return null for no value
        //int return 0 for no values

         public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();

            int[] arr=new int[n];
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            Integer[] dp= new Integer[n+1];
            dp[n]=0;

            for(int i=n-1; i>=0;i--){
                if(arr[i]>0){
                    int min =Integer.MAX_VALUE;

                    for(int j=1;j<=arr[i] && i+j<dp.length ;j++){
                        if(dp[i+j] !=null){
                        min=Math.min(min, dp[i+j]);
                        }
                    }
                    if(min != Integer.MAX_VALUE){
                        dp[i]=min+1;
                    }
                }
            }

            System.out.println(dp[0]);
        }
    
}
