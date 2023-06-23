def solution(m, n, puddles):
    answer = 0
    board = [[0]*(m+1) for _ in range(n+1)]
    board[0][1]=1
    puddles_set = set(map(tuple,puddles))
    
    for i in range(1,n+1):
        for j in range(1,m+1):
            if (j,i) in puddles_set:
                continue
            board[i][j]=board[i-1][j]+board[i][j-1]
    
    answer = board[-1][-1]%1000000007
    return answer