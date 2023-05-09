import sys

R,C = map(int,input().split())
pasture = [list(input()) for _ in range(R)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

for i in range(R):
    for j in range(C):
        if pasture[i][j]=="S":
            for dir in range(4):
                nx=i+dx[dir]
                ny=j+dy[dir]
                if nx<0 or ny<0 or nx>=R or ny>=C:
                    continue
                if pasture[nx][ny]=="W":
                    print(0)
                    sys.exit()
                if pasture[nx][ny]==".":
                    pasture[nx][ny]="D"
else:
    print(1)
    for i in range(R):
        print("".join(pasture[i]))