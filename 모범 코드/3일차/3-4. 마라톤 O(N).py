n = int(input())
cor = []
dis = 0
for i in range(n):
	cor.append(list(map(int, input().split())))
	
	if i == 0: continue
	dis += abs(cor[i][0]-cor[i-1][0]) + abs(cor[i][1]-cor[i-1][1])
# 모든 체크포인트를 돌았을 때 거리 구하기
	
mini = 4000 * n		# 이론 상 dis에 들어갈 수 있는 가장 큰 값
for i in range(1, n-1):
	# i번째 체크 포인트를 건너 뛰는 경우:
	# dis - ((i-1)-i 거리) - (i-(i+1) 거리) + ((i-1)-(i+1) 거리)
	dis_ = dis - (abs(cor[i][0]-cor[i-1][0]) + abs(cor[i][1]-cor[i-1][1])) - (abs(cor[i+1][0]-cor[i][0]) + abs(cor[i+1][1]-cor[i][1])) + (abs(cor[i+1][0]-cor[i-1][0]) + abs(cor[i+1][1]-cor[i-1][1]))
	
	mini = min(mini, dis_)

print(mini)