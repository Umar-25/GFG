//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {

    public static boolean isZigzag(int n, int[] arr) {
        int f = 1;

        for (int i = 1; i < n; i++) {
            if (f == 1) {
                if (arr[i - 1] > arr[i]) return false;
            } else {
                if (arr[i - 1] < arr[i]) return false;
            }
            f ^= 1;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            obj.zigZag(n, arr);
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == i % 2) {
                    flag = false;
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("0");
            } else {

                boolean check = isZigzag(n, arr);
                if (check) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public void zigZag(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i] > arr[i + 1]) {
                    // Swap arr[i] and arr[i + 1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    // Swap arr[i] and arr[i + 1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {4, 3, 7, 8, 6, 2, 1};
        sol.zigZag(arr1.length, arr1);
        System.out.println("Array after zig-zag transformation: " + Arrays.toString(arr1));

        int[] arr2 = {4, 7, 3, 8, 2};
        sol.zigZag(arr2.length, arr2);
        System.out.println("Array after zig-zag transformation: " + Arrays.toString(arr2));
    }
}


