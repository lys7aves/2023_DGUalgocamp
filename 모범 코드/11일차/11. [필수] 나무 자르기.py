N, M = map(int, input().split())
arr = list(map(int, input().split()))

l = 0
r = 1000000000
while l < r:
	m = (l+r+1)//2
	
	sum = 0
	for h in arr:
		if h > m: sum += h-m
	
	if sum >= M: l = m
	else: r = m-1

print(l)