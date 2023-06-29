r,c = map(int,input().split())
board = [list(input()) for _ in range(r)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

byeland = []
for i in range(r):
    for j in range(c):
        if board[i][j]=="X":
            cnt=0
            for dir in range(4):
                nx=i+dx[dir]
                ny=j+dy[dir]
                if nx<0 or ny<0 or nx>=r or ny>=c:
                    cnt+=1
                    continue
                if board[nx][ny]==".":
                    cnt+=1
                    continue
                
            if cnt>=3:
                byeland.append((i,j))

for x,y in byeland:
    board[x][y]="."


top=0
bottom=r-1
left=0
right=c-1

for i in range(r):
    top=i
    flag=True
    for j in range(c):
        if board[i][j]=="X":
            flag=False
            break
    if not flag:
        break

for i in range(r-1,-1,-1):
    bottom=i
    flag=True
    for j in range(c):
        if board[i][j]=="X":
            flag=False
            break
    if not flag:
        break

for i in range(c):
    left=i
    flag=True
    for j in range(r):
        if board[j][i]=="X":
            flag=False
            break
    if not flag:
        break

for i in range(c-1,-1,-1):
    right=i
    flag=True
    for j in range(r):
        if board[j][i]=="X":
            flag=False
            break
    if not flag:
        break

for i in range(top,bottom+1):
    print("".join(board[i][left:right+1]))