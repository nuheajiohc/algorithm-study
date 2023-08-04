n = int(input())
d = [[1]*10 for _ in range(65)]

for i in range(2,65):
    for j in range(8,-1,-1):
        d[i][j]=d[i-1][j]+d[i][j+1]

for _ in range(n):
    print(sum(d[int(input())]))