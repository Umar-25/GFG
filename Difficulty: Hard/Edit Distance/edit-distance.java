//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




class Solution {
    public int ans(String str1, String str2, int n, int m, int[][] dp) {
        if (n == -1) return m + 1;
        if (m == -1) return n + 1;
        if (dp[n][m] != Integer.MAX_VALUE) return dp[n][m];
        
        if (str1.charAt(n) == str2.charAt(m)) {
            return dp[n][m] = Math.min(dp[n][m], ans(str1, str2, n - 1, m - 1, dp));
        }
        
        dp[n][m] = Math.min(dp[n][m], 1 + ans(str1, str2, n - 1, m - 1, dp));
        dp[n][m] = Math.min(dp[n][m], 1 + ans(str1, str2, n - 1, m, dp));
        dp[n][m] = Math.min(dp[n][m], 1 + ans(str1, str2, n, m - 1, dp));
        
        return dp[n][m];
    }
    
    public int editDistance(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return ans(str1, str2, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(sol.editDistance(str1, str2)); // Output: 5
    }
}
