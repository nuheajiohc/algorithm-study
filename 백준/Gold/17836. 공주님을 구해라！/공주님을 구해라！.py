from collections import deque

n,m,t = map(int,input().split())

tower = [list(map(int,input().split())) for _ in range(n)]
vis = [[0 for _ in range(m)] for _ in range(n)]
queue =deque([(0,0)])

dx = [0,0,1,-1]
dy = [1,-1,0,0]

vis[0][0]=1
def bfs(q):
    gram_x=0
    gram_y=0
    flag=False
    while q:
        x,y = q.popleft()
        for dir in range(4):
            nx = x+dx[dir]
            ny = y+dy[dir]
            if nx<0 or ny<0 or nx>=n or ny>=m:
                continue
            if vis[nx][ny] or tower[nx][ny]==1:
                continue
            if tower[nx][ny]==2:
                gram_x=nx
                gram_y=ny
                flag=True
            vis[nx][ny]=vis[x][y]+1
            q.append((nx,ny))
    time=10001
    if vis[n-1][m-1]:
        time=vis[n-1][m-1]-1
    if flag:
        time=min(time,vis[gram_x][gram_y]+abs(n-1-gram_x)+abs(m-1-gram_y)-1)
    if time<=t:
        return time
    else:
        return "Fail"

print(bfs(queue))