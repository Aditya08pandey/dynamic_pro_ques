import java.util.*;

class fibonacciSeries{
    public static Map<Integer,Long> memo= new HashMap<>();

    //T.C = O(2^N) AND S.C= O(LOG N) OR O(N).

    //function calling - recursive approach
    public static int fib(int n){
        // 1.base case
        if(n<=1){
            return n;
        }
        else 
        return fib(n-1) + fib(n-2);
    }


    //function calling - using Memoization D.P (enhanced recursion)
    //t.c= O(N); S.C= O(N)

    public static long fibMemo(int n){
        //base case
        if(n<=1){
            return n;
        }

        //optimized logic - avoid recomputation of recursive function call
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        //2. Recursive function call
        long fibVal= fibMemo(n-1) + fibMemo(n-2);
        memo.put(n,fibVal);
        return fibVal;
    }

    //FUNCTION CALLING - Tabulation method in D.P = no recursion
    //s.c = O(N) AND t.c = O(N)

    public static long fibTab(int n){
        //initialization of an array
        long fib[] = new long[n+1];
        fib[0]=0;
        fib[1]=1;

        for(int i=2;i<=n;i++)
        {
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];
    }

    //function calllig by the most optimised approach
    //t.c = O(N) BUT s.c = O(1)

    public static long fibOpt(int n){
        long first=0, second=1, third;

        for(int i=2;i<=n;i++){
            third=first+second;
            first=second;
            second=third;

        }
        return second;
    }
    
    public static void main(String[] args) {
        int n=50;
        System.out.println("The fibonacci series value is: "+fibTab(n));
    }

}