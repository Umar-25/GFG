//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        int l = 0, r = n - 2; // r should be n - 2 because arr2 is of length n - 1
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr1[mid] == arr2[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l; // l will be the index of the extra element
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {2, 4, 6, 8, 9, 10, 12};
        int[] arr2 = {2, 4, 6, 8, 10, 12};
        System.out.println("The index of the extra element is: " + sol.findExtra(arr1.length, arr1, arr2));

        int[] arr3 = {3, 5, 7, 8, 11, 13};
        int[] arr4 = {3, 5, 7, 11, 13};
        System.out.println("The index of the extra element is: " + sol.findExtra(arr3.length, arr3, arr4));
    }
}
