from collections import deque

N,L,R = map(int,input().split())
country = [list(map(int,input().split())) for _ in range(N)]
dx=[1,0,0,-1]
dy=[0,-1,1,0]
result=0

def check(x,y):
    for dir in range(4):
        nx= x+dx[dir]
        ny= y+dy[dir]
        if 0<=nx<N and 0<=ny<N:
            if L<=abs(country[nx][ny]-country[x][y])<=R:
                return 0
    return 1

while True:
    vis=[[0]*N for _ in range(N)]
    flag=False
    for i in range(N):
        for j in range(N):
            if vis[i][j] or check(i,j):
                continue
            queue=deque()
            queue.append([i,j])
            countrys=[[i,j]]
            number_of_people=0
            number_of_country=0
            avg_of_people=0
            vis[i][j]=1
            while queue:
                cur_x,cur_y=queue.popleft()
                number_of_people+=country[cur_x][cur_y]
                number_of_country+=1
                for dir in range(4):
                    nx=cur_x+dx[dir]
                    ny=cur_y+dy[dir]
                    if nx<0 or ny<0 or nx>=N or ny>=N:
                        continue
                    if vis[nx][ny]:
                        continue
                    if L<=abs(country[nx][ny]-country[cur_x][cur_y])<=R:
                        flag=True
                        queue.append([nx,ny])
                        vis[nx][ny]=1
                        countrys.append([nx,ny])
            if number_of_country:
                avg_of_people=number_of_people//number_of_country
                for x,y in countrys:
                    country[x][y]=avg_of_people
    if flag:
        result+=1
    else:
        break
print(result)
