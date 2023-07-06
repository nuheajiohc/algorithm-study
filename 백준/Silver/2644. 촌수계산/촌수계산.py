n = int(input())
a,b = map(int,input().split())
m = int(input())
graph = [[] for _ in range(n+1)]
vis = [False] * (n+1)

for _ in range(m):
    x,y = map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)

def dfs(v,cnt):
    if v==b:
        print(cnt)
        return
    
    for i in graph[v]:
        if not vis[i]:
            vis[i]=True
            dfs(i,cnt+1)

vis[a]=True
dfs(a,0)
if not vis[b]:
    print(-1)
