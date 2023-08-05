N = int(input())

dic = {}
for i in range(N):
	book = input()
	
	if book not in dic: dic[book] = 0
	dic[book] += 1

max = 0
book = ""
for key, val in dic.items():
	if max < val or (max == val and book > key):
		max = val
		book = key

print(book)