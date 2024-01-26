//Memoisation
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return climb(n,dp);
    }
    public int climb(int n, int[] dp){
        if(n == 0 || n == 1) return 1;
        if(dp[n] != 0) return dp[n];

        return dp[n] = climb(n-1,dp) + climb(n-2,dp);
    }
}

//Tabulation
class Solution {
    public int tabulation(int n, int[] dp){
        for(int i = 0;i<=n;i++){
            if(i == 0 || i == 1){
                dp[i] = 1;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return tabulation(n,dp);
    }
}

//Optimized
class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}