def lower_bound(N, arr, K):
	answer = N
	l = 0
	r = N-1
	
	while l <= r:
		m = (l+r)//2
		if arr[m] < K:
			l = m+1
		else:
			answer = m
			r = m-1
	
	return answer+1

N = int(input())
arr = list(map(int, input().split()))
K = int(input())

print(lower_bound(N, arr, K))