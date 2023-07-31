#include <stdio.h>
#include <vector>

using namespace std;

int chk[101];
vector<int> edge[101];

int dfs(int v)
{
	int i, cnt=1;
	
	if(chk[v]) return 0;
	chk[v] = true;
	
	printf("%d ", v);
	
	for(i=0; i<edge[v].size(); i++){
		cnt += dfs(edge[v][i]);
	}
	
	return cnt;
}

int main()
{
	int n, m, a, b;
	
	scanf("%d %d", &n, &m);
	while(m--){
		scanf("%d %d", &a, &b);
		edge[a].push_back(b);
		edge[b].push_back(a);
	}
	
	printf("%d", dfs(1)-1);
	
	return 0;
}