N,M = map(int,input().split())
T=[int(input()) for _ in range(N)]
minTime = 1
maxTime = max(T)*M
answer=max(T)*M
while minTime<=maxTime:
    people=0
    mid=(minTime+maxTime)//2
    for i in T:
        people+=mid//i
    if people<M:
        minTime=mid+1
    else:
        maxTime=mid-1
        answer=mid

print(answer)