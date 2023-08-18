import sys
input = sys.stdin.readline

n,m = map(int,input().split())
up=[]
down=[]
for i in range(n):
    length= int(input())
    if i%2==0:
        down.append(length)
    else:
        up.append(length)

up.sort()
down.sort()
def binary_search(arr,target):
    st=0
    en=len(arr)-1
    while st<=en:
        mid=(st+en)//2
        if target<=arr[mid]:
            en=mid-1
        else:
            st=mid+1
    return len(arr)-st

min_v=2e9
cnt=0
for i in range(1,m+1):
    a,b=binary_search(down,i),binary_search(up,m-i+1)
    s=a+b
    if min_v>s:
        cnt=1
        min_v=s
    elif min_v==s:
        cnt+=1

print(min_v, cnt)