from collections import deque

row,col=map(int,input().split())
grid=[]
vis=[]
count=0
max_pic=0
cur_pic=1
dx = [0,0,1,-1]
dy = [1,-1,0,0]

def bfs(i,j):
    vis[i][j]=True
    queue= deque([[i,j]])
    while queue:
        cur_x,cur_y=queue.popleft()
        for dir in range(4):
            nx = cur_x+dx[dir]
            ny = cur_y+dy[dir]
            if nx<0 or ny<0 or nx>=row or ny>=col:
                continue
            if vis[nx][ny] or not grid[nx][ny]:
                continue
            vis[nx][ny]=True
            queue.append([nx,ny])
            global cur_pic
            cur_pic+=1

for i in range(row):
    grid.append(list(map(int,input().split())))
    vis.append([False]*col)

for i in range(row):
    for j in range(col):
        if not vis[i][j] and grid[i][j]:
            bfs(i,j)
            max_pic = max(max_pic,cur_pic)
            cur_pic=1
            count+=1

print(count)
print(max_pic)