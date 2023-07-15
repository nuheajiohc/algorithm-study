from collections import deque
    
def move_fire(building,vis,w,h):
    fire_pos = deque()
    for i in range(h):
        for j in range(w):
            if building[i][j]=="*":
                fire_pos.append((i,j))
                vis[i][j]=1
    while fire_pos:
        x,y = fire_pos.popleft()
        for dir in range(4):
            nx=x+dx[dir]
            ny=y+dy[dir]
            if nx<0 or ny<0 or nx>=h or ny>=w:
                continue
            if vis[nx][ny] or building[nx][ny]=="#":
                continue
            vis[nx][ny]=vis[x][y]+1
            fire_pos.append((nx,ny))

def move_sang(building,vis,w,h):
    sang_pos = deque()
    for i in range(h):
        for j in range(w):
            if building[i][j]=="@":
                sang_pos.append((i,j))
                vis[i][j]=1
    while sang_pos:
        x,y = sang_pos.popleft()
        for dir in range(4):
            nx=x+dx[dir]
            ny=y+dy[dir]
            if nx<0 or ny<0 or nx>=h or ny>=w:
                return vis[x][y]
            if building[nx][ny]=="#" or (vis[nx][ny] and vis[nx][ny]<=vis[x][y]+1):
                continue
            vis[nx][ny]=vis[x][y]+1
            sang_pos.append((nx,ny))
    
    return "IMPOSSIBLE"

def testcase():
    w,h = map(int,input().split())
    building = [list(input()) for _ in range(h)]
    vis = [[0]*w for _ in range(h)]
    move_fire(building,vis,w,h)
    print(move_sang(building,vis,w,h))

n = int(input())
dx=[0,0,1,-1]
dy=[1,-1,0,0]
for _ in range(n):
    testcase()