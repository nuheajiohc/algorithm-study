from collections import deque
import sys
input = sys.stdin.readline

a,b = map(int,input().split())

q = deque()
q.append(a)
vis = [0]*100001
min_time=0
count=0
while q:
    x= q.popleft()
    if x==b:
        count+=1
        continue

    for nx in [x-1,x+1,x*2]:
        if 0<=nx<=100000 and (vis[nx]==0 or vis[nx]==vis[x]+1):
            vis[nx] = vis[x]+1
            q.append(nx)

min_time = vis[b]
print(min_time)
print(count)