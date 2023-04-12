N =int(input())
memo=[[0]*10 for _ in range(N+1)]
for i in range(1,10):
    memo[1][i]=1

for i in range(2,N+1):
    for j in range(10):
        if j==0:
            memo[i][j]=memo[i-1][j+1]
        elif j==9:
            memo[i][j]=memo[i-1][j-1]
        else:
            memo[i][j]=memo[i-1][j-1]+memo[i-1][j+1]

print(sum(memo[N])%1000000000)