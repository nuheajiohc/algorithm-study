from collections import deque

n,m,a,b,k = map(int,input().split())
board = [[0]*m for _ in range(n)]
vis = [[0]*m for _ in range(n)]
dx = [0,0,1,-1]
dy = [1,-1,0,0]

for i in range(k):
    x,y=map(int,input().split())
    board[x-1][y-1]=1

s_x,s_y = map(int,input().split())
s_x-=1
s_y-=1
e_x,e_y = map(int,input().split())
e_x-=1
e_y-=1

q = deque()
q.append((s_x,s_y))
vis[s_x][s_y]=1
def check(x,y,dir):
    for i in range(a):
        for j in range(b):
            nx = x+dx[dir]+i
            ny = y+dy[dir]+j
            if nx<0 or ny<0 or nx>=n or ny>=m:
                return False
            if board[nx][ny]==1:
                return False
    return True

while q:
    x,y=q.popleft()
    for dir in range(4):
        nx=x+dx[dir]
        ny=y+dy[dir]
        if nx<0 or ny<0 or nx>=n or ny>=m:
            continue
        if vis[nx][ny]:
            continue
        if check(x,y,dir):
            vis[nx][ny]=vis[x][y]+1
            q.append((nx,ny))
if vis[e_x][e_y]:
    print(vis[e_x][e_y]-1)
else:
    print(-1)