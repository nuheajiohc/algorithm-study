board=[]
dx=[0,1,1,-1]
dy=[1,0,1,1]
end=False
for i in range(19):
    board.append(list(input().split()))
for i in range(19):
    for j in range(19):
        if board[i][j]=="0":
            continue
        cur = board[i][j]
        for dir in range(4):
            nx=i
            ny=j
            cnt=1
            while True:
                nx += dx[dir]
                ny += dy[dir]
                if nx<0 or ny<0 or nx>=19 or ny>=19:
                    if cnt==5:
                        end=True
                    if i-dx[dir]>=0 and j-dy[dir]>=0 and i-dx[dir]<19 and j-dy[dir]<19:
                        if board[i-dx[dir]][j-dy[dir]]==cur:
                            end=False
                    break
                if board[nx][ny]!=cur:
                    if cnt==5:
                        end=True
                    if i-dx[dir]>=0 and j-dy[dir]>=0 and i-dx[dir]<19 and j-dy[dir]<19:
                        if board[i-dx[dir]][j-dy[dir]]==cur:
                            end=False
                    break
                cnt+=1
            if end==True:
                print(cur)
                print(i+1,j+1)
                break
        if end==True:
            break
    if end==True:
        break
if end==False:
    print(0)