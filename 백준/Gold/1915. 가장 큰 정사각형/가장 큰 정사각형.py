n,m = map(int,input().split())
square = [list(map(int,list(input()))) for _ in range(n)]
max_square=0

for i in range(1,n):
    for j in range(1,m):
        if square[i][j]:
            square[i][j]+=min(square[i-1][j],square[i][j-1],square[i-1][j-1])

for i in range(n):
    for j in range(m):
        if square[i][j]>max_square:
            max_square=square[i][j]

print(max_square**2)