import sys

board = [list(map(int,input().split())) for _ in range(9)]
blank_arr=[]
for i in range(3):
    for j in range(3):
        for k in range(i*3,(i*3)+3):
            for l in range(j*3,(j*3)+3):
                if board[k][l]==0:
                    blank_arr.append((k,l))

def check_possible_num(x,y):
    num = {i for i in board[x]}

    for i in range(9):
        num.add(board[i][y])

    r = int(x/3)*3
    w = int(y/3)*3
    for i in range(r,r+3):
        for j in range(w,w+3):
            num.add(board[i][j])

    possible_num={i for i in range(1,10)}
    return possible_num-num

def backtracking(k):
    if k==len(blank_arr):
        for i in range(9):
            print(*board[i])
        sys.exit()

    x,y=blank_arr[k]
    possible_num = check_possible_num(x,y)
    
    for i in possible_num:
        board[x][y]=i
        backtracking(k+1)
        board[x][y]=0

backtracking(0)