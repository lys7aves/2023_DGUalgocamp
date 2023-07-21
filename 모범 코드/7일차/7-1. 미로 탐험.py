import sys
from collections import deque

dx = [0,1,0,-1]
dy = [1,0,-1,0]

N,M = map(int,sys.stdin.readline().split())
arr = [list(map(int,sys.stdin.readline().strip())) for _ in range(N)]
dist = [[0]*M for _ in range(N)]

que = deque()
que.append([0, 0, 1])
while que:
	x, y, d = que.popleft()
	
	if x < 0 or x >= N or y < 0 or y >= M: continue
	if arr[x][y] == 0 or dist[x][y] > 0: continue
	dist[x][y] = d
	
	for i in range(4):
		que.append([x+dx[i], y+dy[i], d+1])

if dist[N-1][M-1] == 0:
    print(-1)
else:
    print(dist[N-1][M-1])
