n,m,k = map(int,input().split())

dx = [-1,-1,0,1,1,1,0,-1]
dy = [0,1,1,1,0,-1,-1,-1]

board = [[0]*n for _ in range(n)]
d_state={True:[0,2,4,6],False:[1,3,5,7]}
fireball_info = [list(map(int,input().split())) for _ in range(m)]

for i in range(len(fireball_info)):
    fireball_info[i][0]-=1
    fireball_info[i][1]-=1

for i in range(1,k+1):
    storage = [[0]*n for _ in range(n)]
    while len(fireball_info)!=0:
        r,c,m,s,d=fireball_info.pop()
        nx = (r+(dx[d]*s))%n
        ny = (c+(dy[d]*s))%n
        if board[nx][ny]!=i:
            board[nx][ny]=i
            storage[nx][ny]=[]
        storage[nx][ny].append([m,s,d])

    for j in range(n):
        for k in range(n):
            if board[j][k]==i:
                total_m=0
                total_s=0
                total_d=storage[j][k][0][2]
                cur_d_state=True
                if len(storage[j][k])>1:
                    for m,s,d in storage[j][k]:
                        total_m+=m
                        total_s+=s
                        if total_d%2 == d%2:
                            total_d=d
                        else:
                            cur_d_state=False
                    total_m//=5
                    total_s//=len(storage[j][k])

                    if total_m!=0:
                        for dir in d_state[cur_d_state]:
                            fireball_info.append([j,k,total_m,total_s,dir])
                else:
                    fireball_info.append([j,k,*storage[j][k][0]])

result=0
for x,y,m,s,d in fireball_info:
    result+=m          
print(result)     