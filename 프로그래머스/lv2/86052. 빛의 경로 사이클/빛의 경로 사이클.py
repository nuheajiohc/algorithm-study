def solution(grid):
    answer = []
    r,c= len(grid),len(grid[0])
    board=[[[0,0,0,0] for _ in range(c)] for _ in range(r)]
    dx=[1,0,-1,0]#하우상좌
    dy=[0,1,0,-1]
    for x in range(r):
        for y in range(c):
            for dir in range(4):
                cnt=0
                while not board[x][y][dir]:
                    board[x][y][dir]=1
                    cnt+=1
                    x=(x+dx[dir])%r
                    y=(y+dy[dir])%c
                    
                    if grid[x][y]=="L":
                        dir=(dir-1)%4
                    elif grid[x][y]=="R":
                        dir=(dir+1)%4
                if cnt:
                    answer.append(cnt)
                    
    return sorted(answer)