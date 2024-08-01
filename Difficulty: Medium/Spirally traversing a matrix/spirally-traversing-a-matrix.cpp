//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<int> spirallyTraverse(vector<vector<int> > &matrix) {
        vector<int>ans;
        int str = 0,stc = 0,enr = matrix.size()-1,enc = matrix[0].size()-1;
        while(ans.size() < matrix.size() * matrix[0].size()){
            for(int j=stc;j<=enc;j++){
                ans.push_back(matrix[str][j]);
            }
            str++;
            if(ans.size() == matrix.size() * matrix[0].size())break;
            for(int i=str;i<=enr;i++){
                ans.push_back(matrix[i][enc]);
            }
            enc--;
            if(ans.size() == matrix.size() * matrix[0].size())break;
            for(int j=enc;j >= stc;j--){
                ans.push_back(matrix[enr][j]);
            }
            enr--;
            if(ans.size() == matrix.size() * matrix[0].size())break;
            for(int i=enr;i>=str;i--){
                ans.push_back(matrix[i][stc]);
            }
            if(ans.size() == matrix.size() * matrix[0].size())break;
            stc++;
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;

    while (t--) {
        int r, c;
        cin >> r >> c;
        vector<vector<int>> matrix(r, vector<int>(c, 0));

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cin >> matrix[i][j];
            }
        }

        Solution ob;
        vector<int> result = ob.spirallyTraverse(matrix);
        for (int i = 0; i < result.size(); ++i)
            cout << result[i] << " ";
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends