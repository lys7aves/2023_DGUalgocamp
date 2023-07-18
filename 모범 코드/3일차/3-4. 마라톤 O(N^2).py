n = int(input())
cor = []
for i in range(n):
	cor.append(list(map(int, input().split())))

mini = 4000 * n		# 이론 상 dis에 들어갈 수 있는 가장 큰 값
for i in range(1, n-1):
	dis = 0
	for j in range(1, n):
		if j == i:
			continue
		elif j == i+1:
			dis += abs(cor[j][0]-cor[j-2][0]) + abs(cor[j][1]-cor[j-2][1])
		else:
			dis += abs(cor[j][0]-cor[j-1][0]) + abs(cor[j][1]-cor[j-1][1])
	
	mini = min(mini, dis)

print(mini)