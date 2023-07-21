import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
h,w,sr,sc,fr,fc = map(int,input().split())
vis = [[False]*m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if board[i][j]==1:
            for x in range(max(0,i-h+1), min(n,i+1)):
                for y in range(max(0,j-w+1), min(m,j+1)):
                    vis[x][y] = True

dx = [0,0,1,-1]
dy = [1,-1,0,0]
vis[sr-1][sc-1]=True
def bfs():
    q = deque([(sr-1,sc-1,0)])
    while q:
        x,y,count=q.popleft()
        if (x,y) == (fr-1,fc-1):
            return count
        for dir in range(4):
            nx = x + dx[dir]
            ny = y + dy[dir]
            if 0<=nx<=n-h and 0<=ny<=m-w and not vis[nx][ny]:
                q.append((nx,ny,count+1))
                vis[nx][ny]=True
    return -1

print(bfs())