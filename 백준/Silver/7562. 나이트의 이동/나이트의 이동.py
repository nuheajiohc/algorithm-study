from collections import deque

T = int(input())
dx = [1,1,2,2,-1,-1,-2,-2]
dy = [2,-2,1,-1,2,-2,-1,1]
def bfs(st_x,st_y,des_x,des_y,size):
    queue=deque()
    queue.append((st_x,st_y))
    board[st_x][st_y]=1
    if st_x==des_x and st_y==des_y:
        return 0
    while queue:
        x,y=queue.popleft()
        for dir in range(8):
            nx,ny=x+dx[dir],y+dy[dir]
            if nx<0 or ny<0 or nx>=size or ny>=size:
                continue
            if board[nx][ny]:
                continue
            board[nx][ny]=board[x][y]+1
            queue.append((nx,ny))
            if nx==des_x and ny==des_y:
                return board[nx][ny]-1
for _ in range(T):
    I = int(input())
    board = [[0]*I for _ in range(I)]
    st_x,st_y=map(int,input().split())
    des_x,des_y=map(int,input().split())
    result=bfs(st_x,st_y,des_x,des_y,I)
    print(result)