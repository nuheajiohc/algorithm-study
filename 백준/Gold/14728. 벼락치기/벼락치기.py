import sys
input = sys.stdin.readline

n,t = map(int,input().split())
danwons = [tuple(map(int,input().split())) for _ in range(n)]
d=[[0]*(t+1) for _ in range(n+1)]
for i in range(1,n+1):
    for j in range(1,t+1):
        if danwons[i-1][0]>j:
            d[i][j]=d[i-1][j]
        else:
            d[i][j]=max(d[i-1][j],d[i-1][j-danwons[i-1][0]]+danwons[i-1][1])

print(d[n][t])