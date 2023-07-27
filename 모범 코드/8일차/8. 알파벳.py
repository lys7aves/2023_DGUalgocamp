dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

ans = 0

def dfs(x, y, d):
    global R, C, chk, ans
    
    if x < 0 or x >= R or y < 0 or y >= C: return
    if chk[ord(arr[x][y])]: return
    ans = max(ans, d)
    
    chk[ord(arr[x][y])] = True
    for i in range(4): dfs(x+dx[i], y+dy[i], d+1)
    chk[ord(arr[x][y])] = False

R, C = map(int, input().split())

arr = []
for i in range(R):
    arr.append(input())

chk = [False] * (ord('Z') + 1)
dfs(0, 0, 1)

print(ans)