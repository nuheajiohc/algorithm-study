n,m = map(int,input().split())
wood = [list(map(int,input().split())) for _ in range(n)]
vis = [[0]*m for _ in range(n)]
dx = [0,1,0,-1,0]
dy = [1,0,-1,0,1]
max_s = 0

def func(x,y,s):
    global max_s
    
    if y>=m:
        x+=1
        y=0
    if x>=n:
        max_s = max(max_s,s)   
        return
    if not vis[x][y]:
        for dir in range(4):
            nx1 = x+dx[dir]
            ny1 = y+dy[dir]
            nx2 = x+dx[dir+1]
            ny2 = y+dy[dir+1]
            if 0<=nx1<n and 0<=ny1<m and 0<=nx2<n and 0<=ny2<m:
                if not vis[nx1][ny1] and not vis[nx2][ny2]:
                    temp=s+wood[x][y]*2
                    vis[x][y]=1
                    temp+=wood[nx1][ny1]
                    temp+=wood[nx2][ny2]
                    vis[nx1][ny1]=1
                    vis[nx2][ny2]=1
                    func(x,y+1,temp)
                    vis[x][y]=0
                    vis[nx1][ny1]=0
                    vis[nx2][ny2]=0
    func(x,y+1,s)

if n<2 or m<2:
    print(0)
else:
    func(0,0,0)
    print(max_s)