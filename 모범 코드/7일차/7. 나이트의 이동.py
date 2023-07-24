from collections import deque

dx = [-2, -2, -1, -1, 1, 1, 2, 2]
dy = [-1, 1, -2, 2, -2, 2, -1, 1]

T = int(input())
for t in range(T):
    l = int(input())
    sx, sy = map(int, input().split())
    ex, ey = map(int, input().split())
    
    dist = [[0 for _ in range(l)] for _ in range(l)]
    
    que = deque()
    que.append((sx, sy, 1))
    dist[sx][sy] = 1
    while que:
        x, y, d = que.popleft()
        if x == ex and y == ey: break   # 답을 찾으면 바로 break 해서 시간 줄이기
        
        for i in range(8):
            x_, y_ = x+dx[i], y+dy[i]
            if x_ < 0 or x_ >= l or y_ < 0 or y_ >= l or dist[x_][y_] > 0: continue
            dist[x_][y_] = d+1
            que.append((x+dx[i], y+dy[i], d+1))
    
    print(dist[ex][ey]-1)