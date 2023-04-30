from collections import deque

N,H,D = map(int,input().split())
board = [list(input()) for _ in range(N)]
vis = [[0]*N for _ in range(N)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]
queue = deque()
for i in range(N):
    for j in range(N):
        if board[i][j]=="S":
            queue.append((i,j,H,0,0))
            vis[i][j]=H
flag =False
while queue:
    x,y,now_h,now_d,cnt=queue.popleft()
    
    for dir in range(4):
        nx = x+dx[dir]
        ny = y+dy[dir]

        if nx<0 or ny<0 or nx>=N or ny>=N:
            continue
        if board[nx][ny]=="E":
            print(cnt+1)
            flag=True
            break
        nxt_h = now_h
        nxt_d = now_d

        if board[nx][ny]=="U":
            nxt_d = D
        if nxt_d == 0:
            nxt_h -= 1
        else:
            nxt_d -= 1

        if nxt_h == 0:
            continue
        if vis[nx][ny] < nxt_h:
            vis[nx][ny]= nxt_h
            queue.append((nx,ny,nxt_h,nxt_d,cnt+1))
    if flag:
        break
else:
    print(-1)

