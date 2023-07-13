from collections import deque

f,s,g,u,d = map(int,input().split())
vis = {}
answer = "use the stairs"
vis[s]=0
q= deque([s])
while q:
    x=q.popleft()
    for dir in [u,-d]:
        nx=x+dir
        if nx<1 or nx>f:
            continue
        if nx in vis:
            continue
        vis[nx]=vis[x]+1
        q.append(nx)

if g in vis:
    answer=vis[g]
print(answer)