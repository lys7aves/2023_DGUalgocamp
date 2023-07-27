N = int(input())

flag = False
for i in range(N+1):
    j = i
    s = 0
    while j > 0:
        s += j%10
        j //= 10
    
    if s+i == N:
        print(i)
        flag = True
        break
        
if not flag: print(0)