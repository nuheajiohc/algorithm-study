from collections import deque

w,h = map(int,input().split())
board = [[0]*(w+2) for _ in range(h+2)]
vis = [[0]*(w+2) for _ in range(h+2)]

for i in range(1,h+1):
    board[i][1:w+1] = map(int,input().split())

dx=[-1,-1,0,1,1,0]
dy=[[-1,0,1,0,-1,-1],[0,1,1,1,0,-1,-1]]

q = deque([(0,0)])
vis[0][0]=1
count=0
while q:
    x,y=q.popleft()
    for dir in range(6):
        nx = x + dx[dir]
        ny = y + dy[x%2][dir]
        if nx<0 or ny<0 or nx>=h+2 or ny>=w+2:
            continue
        if board[nx][ny]==1:
            count+=1
        elif board[nx][ny]==0 and vis[nx][ny]==0:
            vis[nx][ny]=1
            q.append((nx,ny))

print(count)