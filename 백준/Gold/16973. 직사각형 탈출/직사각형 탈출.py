import sys
from collections import deque

n,m = map(int,input().split())
board = [list(map(int,sys.stdin.readline().split())) for _ in range(n)]
h,w,s_r,s_c,f_r,f_c = map(int,input().split())

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def check_boundary(x,y,dir):
    if dir==0:
        for i in range(h):
            nx = x+i
            ny = y+w
            if board[nx][ny]==1:
                return False
    elif dir==1:
        for i in range(h):
            nx = x+i
            ny = y-1
            if board[nx][ny]==1:
                return False    
    elif dir==2:
        for i in range(w):
            nx = x+h
            ny = y+i
            if board[nx][ny]==1:
                return False    
    else:
        for i in range(w):
            nx = x-1
            ny = y+i
            if board[nx][ny]==1:
                return False    
    return True

def bfs():
    q = deque([(s_r-1,s_c-1)])
    board[s_r-1][s_c-1]=2
    
    while q:
        x,y=q.popleft()
        for dir in range(4):
            nx = x+dx[dir]
            ny = y+dy[dir]
            if 0 <= nx < n and 0 <= ny < m and 0 <= nx + h - 1 < n and 0 <= ny + w - 1 < m:
                if not board[nx][ny]:
                    if check_boundary(x,y,dir):
                        board[nx][ny]=board[x][y]+2
                        q.append((nx,ny))
                        if (nx,ny)==(f_r-1,f_c-1):
                            print((board[nx][ny]//2)-1)
                            return
            
    if not board[f_r-1][f_c-1]:
        print(-1)
        return
bfs()