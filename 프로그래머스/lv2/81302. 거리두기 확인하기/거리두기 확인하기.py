from collections import deque

dx=[0,0,1,-1]
dy=[1,-1,0,0]

def bfs(case):
    vis=[[-1]*5 for _ in range(5)]
    for i in range(5):
        for j in range(5):
            if case[i][j]=="P":
                q = deque([(i,j)])
                vis[i][j]=0
                while q:
                    x,y=q.popleft()
                    for dir in range(4):
                        nx=x+dx[dir]
                        ny=y+dy[dir]
                        if nx<0 or ny<0 or nx>=5 or ny>=5:
                            continue
                        if vis[nx][ny]==0:
                            continue
                        if case[nx][ny]=="X":
                            continue
                        if case[nx][ny]=="P":
                            return 0
                        vis[nx][ny]=vis[x][y]+1
                        if vis[nx][ny]==2:
                            continue
                        q.append((nx,ny))
    return 1
def solution(places):
    answer = []
    for place in places:
        answer.append(bfs(place))
    return answer
