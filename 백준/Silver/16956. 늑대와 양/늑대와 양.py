from collections import deque
import sys

R,C = map(int,input().split())
pasture = [list(input()) for _ in range(R)]
queue =deque()
dx = [0,0,1,-1]
dy = [1,-1,0,0]
for i in range(R):
    for j in range(C):
        if pasture[i][j]==".":
            pasture[i][j]="D"
        if pasture[i][j]=="S":
              queue.append((i,j))
while queue:
    x,y=queue.popleft()
    for dir in range(4):
        nx=x+dx[dir]
        ny=y+dy[dir]
        if nx<0 or ny<0 or nx>=R or ny>=C:
            continue
        if pasture[nx][ny]=="W":
            print(0)
            sys.exit()
else:
    print(1)
    for i in range(R):
        print("".join(pasture[i]))