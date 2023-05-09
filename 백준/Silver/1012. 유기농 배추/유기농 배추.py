from collections import deque

T = int(input())
dx=[0,0,1,-1]
dy=[1,-1,0,0]
for _ in range(T):
    M,N,K = map(int,input().split())
    land = [[0]*N for _ in range(M)]
    for _ in range(K):
        x,y=map(int,input().split())
        land[x][y]=1
    vis=[[0]*N for _ in range(M)]
    min_bug=0
    def bfs(q):
      while q:
        x,y=q.popleft()
        for dir in range(4):
            nx=x+dx[dir]
            ny=y+dy[dir]
            if nx<0 or ny<0 or nx>=M or ny>=N:
              continue
            if vis[nx][ny] or not land[nx][ny]:
                continue
            vis[nx][ny]=1
            q.append((nx,ny))
    for i in range(M):
        for j in range(N):
            if vis[i][j] or not land[i][j]:
                continue
            queue=deque()
            queue.append((i,j))
            vis[i][j]=1
            bfs(queue)
            min_bug+=1
    print(min_bug)