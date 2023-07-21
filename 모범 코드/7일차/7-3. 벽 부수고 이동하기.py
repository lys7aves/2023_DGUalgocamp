import sys
from collections import deque

dx = [1,0,-1,0]
dy = [0,-1,0,1]

n,m = map(int, sys.stdin.readline().rstrip().split())

arr = [[0 for i in range(m)] for j in range(n)]
for i in range(n):
	s = sys.stdin.readline().rstrip()
	for j in range(m):
		arr[i][j]=int(s[j])

que = deque()
dist = [[[0 for k in range(2)] for j in range(m)] for i in range(n)]

que.append([0, 0, 0, 1])
while (que):
	x, y, z, d = que.popleft()
	
	if x < 0 or x >= n or y < 0 or y >= m: continue
	if arr[x][y] == 1: z += 1
	if z == 2 or dist[x][y][z] > 0: continue
	
	dist[x][y][z] = d
	
	for i in range(4):
		que.append([x+dx[i], y+dy[i], z, d+1])

ans = n * m + 1
if dist[n-1][m-1][0] > 0: ans = min(ans, dist[n-1][m-1][0])
if dist[n-1][m-1][1] > 0: ans = min(ans, dist[n-1][m-1][1])

if (ans == n*m+1): print(-1)
else: print(ans)