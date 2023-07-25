import sys
input = sys.stdin.readline

num = int(input().rstrip())
points = []

for _ in range(num):
    position, color = map(int, input().rstrip().split())
    points.append((position, color))

total_length = 0

for i in range(num):
    min_distance = 100000
    for j in range(num):
        if points[i][1] == points[j][1] and i != j:
            distance = abs(points[i][0] - points[j][0])
            min_distance = min(min_distance, distance)
    total_length += min_distance

print(total_length)