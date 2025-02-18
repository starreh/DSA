/*
 * Problem Statement :
 * Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. 
 * At a time the frog can climb either one or two steps. 
 * A height[N] array is also given. Whenever the frog jumps from a stair i to stair j, 
 * the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. 
 * We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1.
 * 
 * Input :
 * height = [20, 30, 40, 20]
 * 
 * Ouput :
 * 40
 */

import java.util.*;

class Solution {

    private static int func (int n, int[] height, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int oneJump = func(n-1, height, dp) + Math.abs(height[n] - height[n-1]);
        int twoJump = Integer.MAX_VALUE;

        if (n > 1) {
            twoJump = func(n-2, height, dp) + Math.abs(height[n] - height[n-2]);
        }

        dp[n] = Math.min(oneJump, twoJump);
        return dp[n];
    }
    
    public static int solve(int[] height) {
        
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return func(n-1, height, dp);
    }
}

public class FrogJump {

    public static void main (String[] args) {
        int[] height = {20, 30, 40, 20};

        int minCost = Solution.solve(height);
        System.out.println(minCost);
    }
}
