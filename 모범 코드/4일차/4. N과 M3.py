n, m = map(int, input().split())

li = [0 for _ in range(m + 1)]

def dfs(k, li):
    global n, m
    
    if(k == m + 1):
        for i in range(1, m + 1):
            print(li[i], end=' ')
        print('\n', end='')
        return
    for i in range(1, n + 1):
        li[k] = i
        dfs(k + 1, li)
        li[k] = 0
        
dfs(1, li)