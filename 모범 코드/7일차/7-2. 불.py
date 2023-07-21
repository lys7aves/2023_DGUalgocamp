from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(int(input())):
	W, H = map(int, input().split())
	dist = [[0] * W for _ in range(H)]
	arr = []
	que = deque()
	ans = W * H + 1
	for h in range(H):
		arr.append(list(input()))
		for w in range(W):
			if arr[h][w] == '@':
				arr[h][w] = '.'
				x = h
				y = w
			if arr[h][w] == '*':
				que.append((h, w, 1))
				arr[h][w] = '.'
	que.append((x, y, -1))
	
	while que:
		x, y, d = que.popleft()
		d_ = d+1 if d > 0 else d-1
		
		if x < 0 or x >= H or y < 0 or y >= W or arr[x][y] != '.' or dist[x][y] != 0: continue
		if d < 0 and (x == 0 or x == H-1 or y == 0 or y == W-1):
			ans = min(ans, -d)
		
		dist[x][y] = d
		
		for i in range(4):
			que.append((x+dx[i], y+dy[i], d_))
			
	if ans == H*W+1: print("IMPOSSIBLE")
	else: print(ans)
