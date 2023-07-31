from collections import deque

def dfs(v):
    global edge, chk
    
    if(chk[v]): return
    chk[v] = True
    
    print(v, end=' ')
    
    for u in edge[v]:
        dfs(u)

N, M, V = map(int, input().split())

edge = [[] for _ in range(N+1)]
for i in range(M):
    u, v = map(int, input().split())
    edge[u].append(v)
    edge[v].append(u)

for i in range(N+1):
    edge[i].sort()

chk = [False] * (N+1)
dfs(V)
print()

chk = [False] * (N+1)
que = deque()
que.append(V)
while que:
    v = que.popleft()
    
    if(chk[v]): continue
    chk[v] = True
    print(v, end=" ")
    
    for u in edge[v]:
        que.append(u)