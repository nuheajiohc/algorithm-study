from collections import deque

N,M = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(N)]
dx=[0,0,1,1,1,-1,-1,-1]
dy=[1,-1,-1,0,1,-1,0,1]

queue =deque()

for i in range(N):
    for j in range(M):
        if board[i][j]==1:
            queue.append((i,j))
def bfs(q):
    while q:
        x,y=q.popleft()
        for x1,y1 in zip(dx,dy):
            nx=x+x1
            ny=y+y1
            if nx<0 or ny<0 or nx>=N or ny>=M:
                continue
            if board[nx][ny]==1:
                continue
            if not board[nx][ny]:
                board[nx][ny]=board[x][y]+1
            elif board[nx][ny]>board[x][y]+1:
                board[nx][ny]=board[x][y]+1
            else:
                continue
            q.append((nx,ny))

bfs(queue)
max_distance=0
for i in range(N):
    max_distance=max(max_distance,max(board[i]))

print(max_distance-1)