import sys
input = sys.stdin.readline

n,m = map(int,input().split())
d = [1]*(n+1)
nums = []
for i in range(m):
    a,b = map(int,input().split())
    nums.append((a,b))
nums.sort()
for a,b in nums:
    if d[b]<=1+d[a]:
        d[b]=1+d[a]

print(*d[1:])