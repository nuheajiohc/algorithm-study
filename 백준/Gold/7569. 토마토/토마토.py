import sys
from collections import deque

m,n,h = map(int,input().split())
board = [[list(map(int,sys.stdin.readline().split())) for a in range(n)] for b in range(h)]

dx = [0,0,1,-1,0,0]
dy = [0,0,0,0,1,-1]
dz = [1,-1,0,0,0,0]

zero_count=0
q = deque()

for i in range(h):
    for j in range(n):
        for k in range(m):
            if board[i][j][k]==0:
                zero_count+=1
            elif board[i][j][k]==1:
                q.append((i,j,k))

def bfs(zero_count,max_day):
    while q:
        z,x,y=q.popleft()
        for dir in range(6):
            nz = z + dz[dir]
            nx = x + dx[dir]
            ny = y + dy[dir]
            if nz<0 or nz>=h or nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            if board[nz][nx][ny]:
                continue
            board[nz][nx][ny]=board[z][x][y]+1
            if max_day<board[nz][nx][ny]:
                max_day=board[nz][nx][ny]

            zero_count-=1
            q.append((nz,nx,ny))

    if zero_count:
        print(-1)
    else:
        print(max_day-1)

bfs(zero_count,1)