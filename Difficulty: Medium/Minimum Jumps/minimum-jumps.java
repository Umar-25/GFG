//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        int maxi = 0;
        int choice = 0;
        int jumps = 0;
        
        for(int i = 0; i < n - 1; i++){
            maxi = Math.max(maxi, arr[i] + i);
            if(i == choice){
                choice = maxi;
                jumps++;
            }
            if(choice >= n - 1) return jumps;
        }
        return -1;
    }
}    