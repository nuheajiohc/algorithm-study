from collections import deque

m,n = map(int,input().split())

board = [input().split() for _ in range(m)]
vis = [[0]*n for _ in range(m)]

dx = [0,-1,-1,-1,0,1,1,1]
dy = [1,1,0,-1,-1,-1,0,1]

def bfs(i,j):
    q = deque([(i,j)])
    while q:
        x,y = q.popleft()
        for dir in range(8):
            nx = x+dx[dir]
            ny = y+dy[dir]
            
            if nx<0 or ny<0 or nx>=m or ny>=n:
                continue
            if vis[nx][ny] or board[nx][ny]=="0":
                continue

            vis[nx][ny]=1
            q.append((nx,ny))

cnt=0
for i in range(m):
    for j in range(n):
        if board[i][j]=="0" or vis[i][j]==1:
            continue

        vis[i][j]=1
        bfs(i,j)
        cnt+=1

print(cnt)