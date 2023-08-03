import sys
input = sys.stdin.readline

n,m = map(int,input().split())
d = [1]*(n+1)
nums = [list(map(int,input().split())) for _ in range(m)]

nums.sort(key=lambda x:(x[0],x[1]))
for a,b in nums:
    if d[b]<=1+d[a]:
        d[b]=1+d[a]

print(*d[1:])