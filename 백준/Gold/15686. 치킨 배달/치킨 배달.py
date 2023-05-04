from itertools import combinations

N,M = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(N)]
house = []
chichen=[]

for i in range(N):
    for j in range(N):
        if board[i][j]==1:
            house.append((i,j))
        if board[i][j]==2:
            chichen.append((i,j))

c = combinations(chichen,M)
result=1500
for case in c:
    min_distance=0
    for a,b in house:
        temp=101
        for c,d in case:
            temp=min(temp,abs(a-c)+abs(b-d))
        min_distance+=temp
    result=min(result,min_distance)

print(result)