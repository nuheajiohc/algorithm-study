n = int(input())
dp = [[0] * 10 for _ in range(n+1)]
dp[1][1:] = [1] * 9

def solve(i, j):
    if j < 0 or j > 9:
        return 0

    if dp[i][j]:
        return dp[i][j]
    
    if i<1:
        return dp[i][j]

    dp[i][j] = solve(i-1, j-1) + solve(i-1, j+1)

    return dp[i][j]

for j in range(10):
    solve(n, j)
print(sum(dp[n]) % 1_000_000_000)