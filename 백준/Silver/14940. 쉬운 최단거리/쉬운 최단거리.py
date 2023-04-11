from collections import deque

height,width = map(int, input().split())
board = []
vis = []
for i in range(height):
    board.append(list(map(int,input().split())))
    vis.append([0]*width)

dx=[0,0,1,-1]
dy=[1,-1,0,0]
queue =deque()
for i in range(height):
    for j in range(width):
        if board[i][j]==2:
            queue.append([i,j])
            vis[i][j]=0
            break
    if len(queue)==1:
        break

while queue:
    cur_x,cur_y=queue.popleft()
    for dir in range(4):
        nx=cur_x+dx[dir]
        ny=cur_y+dy[dir]
        if nx<0 or ny<0 or nx>=height or ny>=width:
            continue
        if vis[nx][ny] or board[nx][ny]==2 or board[nx][ny]==0:
            continue
        vis[nx][ny]=vis[cur_x][cur_y]+1
        queue.append([nx,ny])

for i in range(height):
    for j in range(width):
        if board[i][j]==1 and vis[i][j]==0:
            vis[i][j]=-1
    print(*vis[i])