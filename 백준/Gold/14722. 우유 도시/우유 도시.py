n = int(input())
city = [list(map(int,input().split())) for _ in range(n)]
vis = [[0]*n for _ in range(n)]
dx=[1,0]
dy=[0,1]

for i in range(n):
    for j in range(n):
        if city[i][j]==0:
            vis[i][j]=max(vis[i][j],1)
        for dir in range(2):
            nx = i+dx[dir]
            ny = j+dy[dir]
            if nx>=n or ny>=n:
                continue
            if city[nx][ny]==vis[i][j]%3:
                vis[nx][ny]=max(vis[nx][ny],vis[i][j]+1)
            else:
                vis[nx][ny]=max(vis[nx][ny],vis[i][j])

print(vis[-1][-1])