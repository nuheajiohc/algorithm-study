import sys
input = sys.stdin.readline

n,m = map(int,input().split())
d = [1]*(n+1)
nums = [tuple(map(int,input().split())) for _ in range(m)]
nums.sort()
for a,b in nums:
    if d[b]<=1+d[a]:
        d[b]=1+d[a]

print(*d[1:])