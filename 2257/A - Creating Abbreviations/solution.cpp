#include <iostream>
#include <vector>
#include <string>
#include <cctype>
 
using namespace std;
 
void solve() {
    int n, m;
    cin >> n >> m;
    
    vector<bool> avail(26, false);
    
    for (int i = 0; i < n; ++i) {
        string w;
        cin >> w;
        avail[toupper(w[0]) - 'A'] = true;
    }
    
    vector<string> A(m);
    for (int i = 0; i < m; ++i) {
        cin >> A[i];
    }
    
    bool changed = true;
    
    while (changed && !A.empty()) {
        changed = false;
        vector<string> next_A;
        
        for (const string& s : A) {
            bool can_form = true;
            for (char c : s) {
                if (!avail[c - 'A']) {
                    can_form = false;
                    break;
                }
            }
            
            if (can_form) {
                if (!avail[s[0] - 'A']) {
                    avail[s[0] - 'A'] = true;
                }
                changed = true;
            } else {
                next_A.push_back(s);
            }
        }
        
        A = next_A;
    }
    
    if (A.empty()) {
        cout << "YES
";
    } else {
        cout << "NO
";
    }
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int t;
    if (cin >> t) {
        while (t--) {
            solve();
        }
    }
    return 0;
}