/*
 * Problem Statement :
 * Given a number of stairs. Starting from the 0th stair we need to climb to the “Nth” stair. 
 * At a time we can climb either one or two steps. 
 * We need to return the total number of distinct ways to reach from 0th to Nth stair.
 * 
 * Input :
 * n = 2
 * 
 * Output :
 * 2 
 * 
 * Explaination :
 * 1 Step + 1 Step
 * 2 Steps
 */


import java.util.*;

class Solution {

    private static int solveI(int n) {
        int total = 0;
        
        int prev = 1;
        int curr = 2;

        for (int i = 3; i <= n; i++) {
            total = prev + curr;
            total = curr;
            curr = total;
        }

        return total;
    }

    private static int solveR(int n) {
        if (n == 0) {
            return 1; // When you are at the top, there is one way to stay at the top, do nothing
        }

        if (n == 1) {
            return 1; // When there is 1 stair left, the only way you can go to the top is by taking 1 step
        }

        int oneSstep = solveR(n-1);
        int twoStep = Integer.MAX_VALUE;
        
        if (n > 1) { // When there is more than 1 step left, you can take the 2 step jump
            twoStep = solveR(n - 2);
        }

        return oneSstep + twoStep;
    }

    private static int solveDP (int n, int[] dp) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }
        
        int oneSstep = solveDP(n-1, dp);
        int twoStep = Integer.MAX_VALUE;

        if (n > 1) {
            twoStep = solveDP(n - 2, dp);
        }

        dp[n] = oneSstep + twoStep;

        return dp[n];
    }
    
    public static int solve(int n) {
        /* Iterative Solution : Bottom-Up */
        // return solveI(n);

        /* Recursive Solution : Top-Down */
        // return solveR(n);

        /* Dynamic Programming Solution */
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solveDP(n, dp);
    }
}


public class ClimbingStairs {
    public static void main (String[] args) {
        int n = 3;
        
        int sol = Solution.solve(n);
        System.out.println(sol);
    }
}
