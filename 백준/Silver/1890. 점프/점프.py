n = int(input())
board = [list(map(int,input().split())) for _ in range(n)]
d = [[0]*n for _ in range(n)]
d[0][0]=1
for i in range(n):
    for j in range(n):
        if not d[i][j]:
            continue
        if i==n-1 and j==n-1:
            break
        if i+board[i][j]<n:
            d[i+board[i][j]][j]+=d[i][j]
        if j+board[i][j]<n:
            d[i][j+board[i][j]]+=d[i][j]
print(d[-1][-1])