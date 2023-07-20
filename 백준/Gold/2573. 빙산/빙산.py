from collections import deque

n,m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def after_minute():
    check = []
    for i in range(n):
        for j in range(m):
            if board[i][j]:
                count=0
                for dir in range(4):
                    nx=i+dx[dir]
                    ny=j+dy[dir]
                    if board[nx][ny]==0:
                        count+=1
                check.append((i,j,count))

    for i,j,count in check:
        if board[i][j]>count:
            board[i][j]-=count
        else:
            board[i][j]=0

def bfs():
    count=0
    vis = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if board[i][j] and not vis[i][j]:
                q = deque([(i,j)])
                vis[i][j]=1
                count+=1
                if count>1:
                    return count
                while q:
                    x,y=q.popleft()
                    for dir in range(4):
                        nx=x+dx[dir]
                        ny=y+dy[dir]
                        if vis[nx][ny] or not board[nx][ny]:
                            continue
                        vis[nx][ny]=1
                        q.append((nx,ny))
    if count==1:
        return count
    else:
        return count

count=0
while True:
    count+=1
    after_minute()
    temp = bfs()
    if temp==2:
        print(count)
        break
    elif temp==0:
        print(0)
        break