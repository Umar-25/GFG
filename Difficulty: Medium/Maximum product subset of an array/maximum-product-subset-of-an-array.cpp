//{ Driver Code Starts
/* Driver program to test above function */

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
public:
    long long int findMaxProduct(vector<int>& arr) {
        int mod = 1e9 + 7;
        int n = arr.size();
        if (n == 1) return arr[0];
        int zero = 0;
        int neg = 0;
        int pos = 0;
        long long int sum = 1;
        long long int maxp = 0;
        long long int sumn = 1;
        int maxi = -10;
        for (auto x : arr) {
            if (x < 0) {
                sumn = (sumn * x) % mod;
                maxi = max(x, maxi);
                neg++;
            }
            else if (x > 0) {
                sum = (sum * x) % mod;
                pos++;
            }
            else {
                zero++;
            }
        }
        if (zero == n) return 0;
        if (neg == 0) return sum;
        if (neg % 2 == 0) return (sumn * sum) % mod;
        else if (neg == 1 && pos == 0) return 0;
        else return ((sumn / maxi) * sum) % mod;
    }
};
//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        long long int ans = ob.findMaxProduct(arr);
        cout << ans << endl;
    }
    return 0;
}

// } Driver Code Ends