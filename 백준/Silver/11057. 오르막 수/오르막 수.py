n = int(input())
d = [[0]*10 for _ in range(n)]

for i in range(n):
    if i==0:
        d[i]=[1]*10
        continue
    for j in range(10):
            d[i][j]=sum(d[i-1][0:j+1])

print(sum(d[n-1])%10007)