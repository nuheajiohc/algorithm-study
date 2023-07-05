from collections import defaultdict
from collections import deque

n = int(input())
x,y = map(int,input().split())
m = int(input())
relationship = defaultdict(list)
vis = [0]*(n+1)
count=0
q = deque()
for _ in range(m):
    a,b = map(int,input().split())
    relationship[a].append(b)
    relationship[b].append(a)

vis[x]=1
q.append(x)

while q:
    temp = q.popleft()
    for i in relationship[temp]:
        if not vis[i]:
            q.append(i)
            vis[i]=vis[temp]+1

if vis[y]:
    print(vis[y]-1)
else:
    print(-1)