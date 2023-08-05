N = int(input())

s = set()
for i in range(N):
	name, status = input().split()
	
	if status == "enter":
		s.add(name)
	else:
		s.remove(name)
		
s = sorted(s)

print(len(s))
for name in s:
	print(name)