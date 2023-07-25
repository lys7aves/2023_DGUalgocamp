import sys

a, b = map(int, sys.stdin.readline().split())

s = a + b

for i in range(3, s+1):
	if i*i > s: break
	
	j = s//i
	if i*j == s and (i-2)*(j-2) == b:
		print(str(j) + " " + str(i))