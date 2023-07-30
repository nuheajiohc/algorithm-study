n,k = map(int,input().split())
d = [[1]*(n+1) for _ in range(k+1)]

for i in range(2,k+1):
    for j in range(1,n+1):
        d[i][j] = d[i-1][j] + d[i][j-1]

print(d[k][n]%1000000000)