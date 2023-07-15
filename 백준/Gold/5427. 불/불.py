from collections import deque

n = int(input())
dx=[0,0,1,-1]
dy=[1,-1,0,0]

def check_st_pos_fire_pos(arr,vis):
    w,h = len(arr[0]),len(arr)
    fire_pos = deque()
    for i in range(h):
        for j in range(w):
            if arr[i][j]=="@":
                st_pos = deque([(i,j)])
                vis[i][j]=1
            if arr[i][j]=="*":
                fire_pos.append((i,j))
                vis[i][j]="fire"

    return st_pos,fire_pos

def move_fire(fire_pos,building,vis):
    length = len(fire_pos)
    for _ in range(length):
        x,y=fire_pos.popleft()
        for dir in range(4):
            nx=x+dx[dir]
            ny=y+dy[dir]
            if nx<0 or ny<0 or nx>=len(vis) or ny>=len(vis[0]):
                continue
            if vis[nx][ny]=="fire" or building[nx][ny]=="#":
                continue
            vis[nx][ny]="fire"
            fire_pos.append((nx,ny))
            
def move_sang(sang_pos,building,vis):
    length = len(sang_pos)
    for _ in range(length):
        x,y=sang_pos.popleft()
        for dir in range(4):
            nx=x+dx[dir]
            ny=y+dy[dir]
            if nx<0 or ny<0 or nx>=len(vis) or ny>=len(vis[0]):
                return "LIVE"
            if vis[nx][ny]=="fire" or vis[nx][ny]==1 or building[nx][ny]=="#":
                continue
            vis[nx][ny]=1
            sang_pos.append((nx,ny))

    if len(sang_pos):
        return "POSSIBLE"
    else:
        return "IMPOSSIBLE"
            
def testcase():
    w,h = map(int,input().split())
    building = [list(input()) for _ in range(h)]
    vis = [[0]*w for _ in range(h)]
    sang_pos,fire_pos = check_st_pos_fire_pos(building,vis)
    cnt=1
    while True:
        move_fire(fire_pos,building,vis)
        status = move_sang(sang_pos,building,vis)
        if status=="POSSIBLE":
            cnt+=1
        elif status=="IMPOSSIBLE":
            return status
        else:
            return cnt

for _ in range(n):
    print(testcase())