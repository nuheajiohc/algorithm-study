import sys

board = [list(map(int,input().split())) for _ in range(9)]
blank_arr=[]
row = [[False]*10 for _ in range(9)]
col = [[False]*10 for _ in range(9)]
rec = [[False]*10 for _ in range(9)]

for i in range(9):
    for j in range(9):
        if board[i][j]:
            row[i][board[i][j]]=True
            col[j][board[i][j]]=True
            rec[(i//3)*3+(j//3)][board[i][j]]=True
        else:
            blank_arr.append((i,j))

def backtracking(k):
    if k==len(blank_arr):
        for i in range(9):
            print(*board[i])
        sys.exit()

    x,y=blank_arr[k]
    for i in range(1,10):
        if not row[x][i] and not col[y][i] and not rec[(x//3)*3+(y//3)][i]:
            board[x][y]=i
            original_row_state = row[x][i]
            original_col_state = col[y][i]
            original_rec_state = rec[(x//3)*3+(y//3)][i]
            row[x][i]=True
            col[y][i]=True
            rec[(x//3)*3+(y//3)][i]=True
            backtracking(k+1)
            board[x][y]=0
            row[x][i]=original_row_state
            col[y][i]=original_col_state
            rec[(x//3)*3+(y//3)][i]=original_rec_state

backtracking(0)