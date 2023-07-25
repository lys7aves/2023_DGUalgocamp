num = int(input())

box = -1
for i in range(num//3+1):
    for j in range(num//5+1):
        if(3*i + 5*j == num and (box > i+j or box == -1)):
            box = i+j
            
print(box)