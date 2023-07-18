n = int(input())

arr = []
for i in range(n):
	arr.append(list(map(int, input().split())))

for i in range(n):
	rank = 1
	for j in range(n):
		if arr[j][0] > arr[i][0] and arr[j][1] > arr[i][1]:
			rank += 1
	
	print(rank, end=' ')