n = int(input())
arr = list(map(int, input().split()))

cnt = 0
for i in range(n):
	for j in range(i, n):
		s = 0
		for k in range(i, j+1):
			s += arr[k]
		
		flag = False
		for k in range(i, j+1):
			if arr[k] * (j-i+1) == s:
				flag = True
				
		if flag:
			cnt = cnt+1
			
print(cnt)