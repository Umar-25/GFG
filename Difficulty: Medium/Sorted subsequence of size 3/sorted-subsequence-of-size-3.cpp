//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

bool isSubSequence(vector<int> &v1, vector<int> &v2) {
    int m = v2.size();
    int n = v1.size();
    int j = 0; // For index of v2

    // Traverse v1 and v2
    for (int i = 0; i < n && j < m; i++) {
        if (v1[i] == v2[j]) {
            j++;
        }
    }
    return (j == m);
}


// } Driver Code Ends
// Function to find three numbers in the given array
// such that arr[smaller[i]] < arr[i] < arr[greater[i]]

// User Template For C++

class Solution {
  public:
    bool f(int i, int prev, int limit, vector<int> &arr, vector<int> &ans) {
    if (limit == 0) return true; 
    if (i == arr.size()) return false;
    if (f(i + 1, prev, limit, arr, ans)) return true;
    if (prev == -1 || arr[prev] < arr[i]) {
        ans.push_back(arr[i]);
        if (f(i + 1, i, limit - 1, arr, ans)) return true;
        ans.pop_back(); 
    }
    return false;
}
    vector<int> find3Numbers(vector<int> &arr) {
        vector<int> ans;
        if (f(0, -1, 3, arr, ans)) {
            return ans;
        } else {
            return {};
        }
    }
};

//{ Driver Code Starts.

// Driver program to test above function
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        int n = arr.size();
        Solution obj;
        auto res = obj.find3Numbers(arr);
        // wrong format output
        if (!res.empty() and res.size() != 3) {
            cout << -1 << "\n";
        }

        if (res.empty()) {
            cout << 0 << "\n";
        } else if ((res[0] < res[1] and res[1] < res[2]) and isSubSequence(arr, res)) {
            cout << 1 << "\n";
        } else {
            cout << -1 << "\n";
        }
    }

    return 0;
}
// } Driver Code Ends