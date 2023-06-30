r,c = map(int,input().split())
board = [list(input()) for _ in range(r)]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

byeland = []
top=r-1
bottom=0
left=c-1
right=0

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
            else:
                top = min(top,i)
                bottom = max(bottom,i)
                left = min(left,j)
                right = max(right,j)
                

for x,y in byeland:
    board[x][y]="."

for i in range(top,bottom+1):
    print("".join(board[i][left:right+1]))