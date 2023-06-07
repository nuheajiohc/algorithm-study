def solution(grid):
    answer = []
    r,c=len(grid),len(grid[0])
    board=[[[] for _ in range(c)] for _ in range(r)]
    direction ={"L":[0,-1],"R":[0,1],"D":[1,0],"U":[-1,0]}
    
    for x in range(r):
        for y in range(c):
            for d in 'ULDR':
                cnt=0
                while d not in board[x][y]:
                    board[x][y].append(d)
                    cnt+=1
                    
                    x = (x+direction[d][0]) % r
                    y = (y+direction[d][1]) % c
                    
                    if grid[x][y] =="L":
                        idx = "ULDR".index(d)
                        d = "ULDR"[(idx+1)%4]
                    elif grid[x][y] =="R":
                        idx = "RDLU".index(d)
                        d="RDLU"[(idx+1)%4]
                if cnt:
                    answer.append(cnt)
    return sorted(answer)