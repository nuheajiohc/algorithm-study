from collections import deque

N = int(input())
square = [list(map(int,input())) for _ in range(N)]
dx = [0,0,1,-1]
dy = [1,-1,0,0]
dangi = 0
dangi_list = []
vis=[[0]*N for _ in range(N)]
def bfs(q):
    temp=1
    while q:
        x,y=q.popleft()
        for dir in range(4):
            nx,ny=x+dx[dir],y+dy[dir]
            if nx<0 or ny<0 or nx>=N or ny>=N:
                continue
            if vis[nx][ny] or not square[nx][ny]:
                continue
            temp+=1
            vis[nx][ny]=1
            q.append((nx,ny))
    dangi_list.append(temp)
for i in range(N):
    for j in range(N):
        if vis[i][j] or not square[i][j]:
            continue
        vis[i][j]=1
        queue=deque()
        queue.append((i,j))
        bfs(queue)
        dangi+=1
print(dangi)
dangi_list.sort()
for i in dangi_list:
    print(i)