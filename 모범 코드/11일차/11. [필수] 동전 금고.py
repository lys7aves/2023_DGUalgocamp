dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, d):
	for i in range(4):
		x_ = x + dx[i]
		y_ = y + dy[i]
		
		if x_ < 0 or x_ >= M or y_ < 0 or y_ >= N: continue
		if arr[x_][y_] - arr[x][y] > d: continue
		if chk[x_][y_]: continue
		
		chk[x_][y_] = True
		dfs(x_, y_, d)

M, N = map(int, input().split())

arr = []
for i in range(M):
	arr.append(list(map(int, input().split())))

chk = [[False] * N for _ in range(M)]

l = 0
r = 1000000000
while l < r:
	m = (l+r) // 2
	
	for i in range(M):
		for j in range(N):
			chk[i][j] = False
	
	chk[0][0] = True
	dfs(0, 0, m)
	
	if(chk[M-1][N-1]): r = m
	else: l = m+1

print(l)