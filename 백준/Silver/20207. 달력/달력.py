N= int(input())
calender = [0]*367

for i in range(N):
    st,en=map(int,input().split())
    for j in range(st,en+1):
        calender[j]+=1

result=0
temp=0
width=0
height=0

for i in calender:
    if i==0:
        temp=width*height
        result+=temp
        temp=0
        width=0
        height=0
    else:
        width+=1
        height=max(height,i)

print(result)
