n = int(input())
arr = list(map(int, input().split()))

s = set()
for a in arr:
	s.add(a)
	
print(len(s))