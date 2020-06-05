// Time complexity - O(nm)
// Space complexity - O(1)

// Implemented using DP.

class Solution {
    public int change(int amount, int[] coins) {
        if(coins.length == 0){
            return 1;
        }
        if(coins == null){
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i< dp.length;i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
