from collections import deque

n,m = map(int,input().split())
board = [list(input()) for _ in range(n)]
vis = [[[0]*2 for _ in range(m)] for _ in range(n)]

dx = [1,-1,0,0]
dy = [0,0,1,-1]

def bfs():
    q = deque([(0,0,0)])
    vis[0][0][0]=1
    while q:
        x,y,wall=q.popleft()
        if x ==n-1 and y==m-1:
            return vis[x][y][wall]

        for dir in range(4):
            nx = x + dx[dir]
            ny = y + dy[dir]
            if nx<0 or ny<0 or nx>=n or ny>=m:
                continue
            if vis[nx][ny][wall]:
                continue
                
            if board[nx][ny]=="0":
                q.append((nx,ny,wall))
                vis[nx][ny][wall]= vis[x][y][wall]+1
            if board[nx][ny]=="1" and wall==0:
                q.append((nx,ny,1))
                vis[nx][ny][1] = vis[x][y][wall]+1

    return -1

print(bfs())