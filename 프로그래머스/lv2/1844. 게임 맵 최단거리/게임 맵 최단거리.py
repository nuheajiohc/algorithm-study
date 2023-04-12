from collections import deque

def solution(maps):
    answer = -1
    width = len(maps[0])
    height = len(maps)
    dx= [0,0,1,-1]
    dy= [1,-1,0,0]
    vis=[[False]*width for _ in range(height)]
    queue =deque([[0,0]])
    vis[0][0]=1
    while queue:
        cur_x,cur_y=queue.popleft()
        for dir in range(4):
            nx= cur_x+dx[dir]
            ny= cur_y+dy[dir]
            if nx<0 or ny<0 or nx>=height or ny>=width:
                continue
            if vis[nx][ny] or not maps[nx][ny]:
                continue
            vis[nx][ny]=vis[cur_x][cur_y]+1
            queue.append([nx,ny])
    if vis[height-1][width-1]:
        answer= vis[height-1][width-1]
    return answer