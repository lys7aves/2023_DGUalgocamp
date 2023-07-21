#include<bits/stdc++.h>
using namespace std;
using pii = pair<int,int>;
int dx[]={0,1,0,-1}, dy[]={1,0,-1,0};
int main()
{
	int T; cin>>T;
	while(T--)
	{
		int H,W; cin>>W>>H;
		string arr[H];
		queue<pii> Q, fireQ;
		vector<vector<int>> dist(H, vector<int>(W, -1));
		vector<vector<int>> firedist(H, vector<int>(W, -1));
		for(int i=0; i<H; i++)
		{
			cin>>arr[i];
			for(int j=0; j<W; j++)
			{
				if(arr[i][j] == '*') firedist[i][j] = 0, fireQ.push({i,j});
				if(arr[i][j] == '@') dist[i][j] = 0, Q.push({i,j});
			}
		}
		while(!fireQ.empty()) {
			auto tmp = fireQ.front(); fireQ.pop();
			int x=tmp.first, y=tmp.second;
			for(int i=0; i<4; i++) {
				int nx = x+dx[i], ny = y+dy[i];
				if(nx<0||nx>=H||ny<0||ny>=W) continue;
				if(arr[nx][ny] == '#') continue;
				if(firedist[nx][ny] != -1) continue;
				firedist[nx][ny] = firedist[x][y] + 1;
				fireQ.push({nx,ny});
			}
		}
		int ans = -1;
		while(!Q.empty()) {
			auto tmp = Q.front(); Q.pop();
			int x=tmp.first, y=tmp.second;
			if(x==0 || x==H-1 || y==0 || y==W-1) {ans=dist[x][y]+1; break;}
			for(int i=0; i<4; i++) {
				int nx = x+dx[i], ny = y+dy[i];
				if(nx<0||nx>=H||ny<0||ny>=W) continue;
				if(arr[nx][ny] == '#') continue;
				if(dist[nx][ny] != -1) continue;
				if(firedist[nx][ny] != -1 && firedist[nx][ny] <= dist[x][y] + 1) continue;
				dist[nx][ny] = dist[x][y] + 1;
				Q.push({nx,ny});
			}
		}
		if(ans == -1) cout<<"IMPOSSIBLE\n";
		else cout<<ans<<'\n';
	}
}
