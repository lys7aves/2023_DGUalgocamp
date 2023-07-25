#include<bits/stdc++.h>

using namespace std;

int board[50][50];

int main()
{
    int n, m, cnt, ans=64, i, j, ii, jj;
    char c;
    
    cin >> n >> m;
    for(i=0; i<n; i++){
        for(j=0; j<m; j++){
            cin >> c;
            board[i][j] = c == 'B';
        }
    }
    
    for(i=0; i<=n-8; i++){
        for(j=0; j<=m-8; j++){
            cnt = 0;
            for(ii=0; ii<8; ii++){
                for(jj=0; jj<8; jj++){
                    cnt += board[i+ii][j+jj] == (i+ii+j+jj)%2;
                }
            }
            
            ans = min(ans, min(cnt, 64-cnt));
        }
    }
    
    cout << ans;
}