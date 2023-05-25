n = int(input())
lines = [list(map(int,input().split())) for _ in range(n)]
lines.sort()
d = [1]*n
for i in range(n):
    for j in range(i):
        if lines[i][1]>lines[j][1]:
            d[i]=max(d[j]+1,d[i])
print(n-max(d))