N,M = map(int,input().split())
commands=[]
trains = [[False]*20 for _ in range(N+1)]

for _ in range(M):
    command=list(map(int, input().split()))
    commands.append(command)
for i in commands:
    if i[0]==1:
        trains[i[1]][i[2]-1]=True
    elif i[0]==2:
        trains[i[1]][i[2]-1]=False
    elif i[0]==3:
        trains[i[1]].insert(0,False)
        trains[i[1]]=trains[i[1]][0:-1]
    else:
        trains[i[1]].append(False)
        trains[i[1]]=trains[i[1]][1:]

new_trains=set()
for i in range(1,len(trains)):
    new_trains.add(tuple(trains[i]))

print(len(new_trains))
