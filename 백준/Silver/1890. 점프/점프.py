N= int(input())
board=[list(map(int,input().split())) for _ in range(N)]
vis=[[0]*N for _ in range(N)]
dx=[1,0]
dy=[0,1]
vis[0][0]=1
for i in range(N):
    for j in range(N):
        if i==N-1 and j==N-1:
            break
        for dir in range(2):
            nx=i+(dx[dir]*board[i][j])
            ny=j+(dy[dir]*board[i][j])
            if nx>=N or ny>=N:
                continue
            vis[nx][ny]+=vis[i][j]
print(vis[N-1][N-1])