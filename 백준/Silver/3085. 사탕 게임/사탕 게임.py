N = int(input())
board = [list(input()) for _ in range(N)]

dx=[0,1]
dy=[1,0]
max_candy=0

def check(board):
    temp=0
    for i in range(N):
        st=0
        en=0
        while en<N:
          if board[i][st]==board[i][en]:
              en+=1
          else:
              temp=max(temp,en-st)
              st=en
        temp=max(temp,en-st)
    for i in range(N):
        st=0
        en=0
        while en<N:
          if board[st][i]==board[en][i]:
              en+=1
          else:
              temp=max(temp,en-st)
              st=en
        temp=max(temp,en-st)
    return temp

for i in range(N):
    for j in range(N):
        for dir in range(2):
            nx=i+dx[dir]
            ny=j+dy[dir]
            if nx>=N or ny>=N:
                continue
            board[i][j],board[nx][ny]=board[nx][ny],board[i][j]
            max_candy=max(max_candy,check(board))
            board[i][j],board[nx][ny]=board[nx][ny],board[i][j]

print(max_candy)