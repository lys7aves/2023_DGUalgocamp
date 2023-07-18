n = int(input())
str1 = input()

cnt = 0
for i in range(n):
	str2 = input()
	
	flag1 = False
	for s in range(len(str2)):
		for d in range(1, len(str2)):
			flag2 = True
			for k in range(len(str1)):
				if s+k*d >= len(str2) or str1[k] != str2[s+k*d]:
					flag2 = False
			
			flag1 |= flag2
	
	if flag1:
		cnt += 1
		
print(cnt)