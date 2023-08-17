import math,sys
input = sys.stdin.readline

n,m = map(int,input().split())
nums = [int(input()) for _ in range(m)]

def binary_search():
    st=1
    en=max(nums)
    while st<=en:
        mid=(st+en)//2
        cnt=0
        for num in nums:
            cnt+=math.ceil(num/mid)
        
        if cnt>n:
            st=mid+1
        else:
            en=mid-1
    return st

print(binary_search())