n = int(input())
arr= list(map(int,input().split()))
d =[1]*n
for i in range(1,n):
    for j in range(i):
        if arr[j]>arr[i]:
            d[i]=max(d[i],d[j]+1)
print(max(d))