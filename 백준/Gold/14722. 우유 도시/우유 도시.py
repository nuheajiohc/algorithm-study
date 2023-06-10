n = int(input())
city = [list(map(int,input().split())) for _ in range(n)]
dp=[[0]*(n+1) for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,n+1):
        dp[i][j]=max(dp[i][j-1],dp[i-1][j])
        if dp[i][j]%3==city[i-1][j-1]:
            dp[i][j]=dp[i][j]+1

print(dp[-1][-1])