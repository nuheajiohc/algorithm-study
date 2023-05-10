from collections import deque

dx = [1,1,1,0,0,-1,-1,-1]
dy = [-1,0,1,-1,1,-1,0,1]

while True:
    w,h=map(int,input().split())
    if w==0 and h==0:
        break
    board=[list(map(int,input().split())) for _ in range(h)]
    vis=[[0]*w for _ in range(h)]
    
    def bfs(q):
        while q:
            x,y=q.popleft()
            for dir in range(8):
                nx=x+dx[dir]
                ny=y+dy[dir]
                if nx<0 or ny<0 or nx>=h or ny>=w:
                    continue
                if vis[nx][ny] or not board[nx][ny]:
                    continue
                vis[nx][ny]=1
                q.append((nx,ny))
    number_of_island=0

    for i in range(h):
        for j in range(w):
            if vis[i][j] or not board[i][j]:
                continue
            queue=deque([(i,j)])
            bfs(queue)
            number_of_island+=1
    print(number_of_island)