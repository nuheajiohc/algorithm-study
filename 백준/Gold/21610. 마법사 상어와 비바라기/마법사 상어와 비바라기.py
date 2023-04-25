from collections import deque

dx = [0,0,-1,-1,-1,0,1,1,1]
dy = [0,-1,-1,0,1,1,1,0,-1]
ddx = [-1,-1,1,1]
ddy = [-1,1,1,-1]
N,M = map(int,input().split())
basket = [list(map(int,input().split())) for _ in range(N)]
coordinate = [list(map(int,input().split())) for _ in range(M)]
queue =deque()
queue.append([N-2,0])
queue.append([N-2,1])
queue.append([N-1,0])
queue.append([N-1,1])

for d,s in coordinate:
    temp=set()
    for i in range(len(queue)):
        queue[i]=[(queue[i][0]+dx[d]*s) % N , (queue[i][1]+dy[d]*s) % N]
        basket[queue[i][0]][queue[i][1]]+=1
    while queue:
        cur_x,cur_y=queue.popleft()
        cnt=0
        temp.add((cur_x,cur_y))
        for dir in range(4):
            nx=cur_x+ddx[dir]
            ny=cur_y+ddy[dir]
            if nx<0 or ny<0 or nx>=N or ny>=N:
                continue
            if basket[nx][ny]>0:
                cnt+=1
        basket[cur_x][cur_y]+=cnt
    for i in range(N):
        for j in range(N):
            if (i,j) in temp:
                continue
            if basket[i][j]>1:
                basket[i][j]-=2
                queue.append([i,j])
s=0
for i in range(N):
    s+=sum(basket[i])
print(s)