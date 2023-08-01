import bisect

N, Q = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

for i in range(Q):
	A, B = map(int, input().split())
	print(bisect.bisect_right(arr, B) - bisect.bisect_left(arr, A))