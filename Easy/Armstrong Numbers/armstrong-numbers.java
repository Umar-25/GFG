//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public String armstrongNumber(int n) {
        int x = n, sumOfCubes = 0;

        while (x > 0) {
            int digit = x % 10;
            sumOfCubes += Math.pow(digit, 3);
            x /= 10;
        }

        if (sumOfCubes == n) {
            return "true";
        } else {
            return "false";
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int n1 = 153;
        int n2 = 372;

        System.out.println(sol.armstrongNumber(n1));  // Output: Yes
        System.out.println(sol.armstrongNumber(n2));  // Output: No
    }
}

