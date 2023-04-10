N = int(input())
schedule = []
calender=[[0]*367 for _ in range(N)]
size = [0]*367
for i in range(N):
    schedule.append(list(map(int,input().split())))

schedule.sort(key=lambda x:(x[0],-x[1]))

for st,en in schedule:
    i=0
    while True:
        if calender[i][st:en+1].count(0)==en-st+1:
            calender[i][st:en+1] = [1]*(en-st+1)
            for j in range(st,en+1):
                size[j] = max(size[j],i+1)
            break
        i+=1
result = 0
temp=0
width=0
height=0
for i in size:
    if i==0:
        temp = width*height
        result+=temp
        width=0
        height=0
        temp=0
        continue
    else:
        width+=1
        height=max(height,i)
print(result)