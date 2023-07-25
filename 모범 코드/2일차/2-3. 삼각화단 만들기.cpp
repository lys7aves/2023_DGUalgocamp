#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n, i, cnt=0;
    
    cin >> n;
    for(i=1; i<n; i++){
        cnt += max(0, (n-i)/2 - max(i, n/2+1-i) + 1);
    }
    
    cout << cnt;
    
    return 0;
}