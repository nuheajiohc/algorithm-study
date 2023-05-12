import sys

n,m = map(int,input().split())
relationship = [[] for _ in range(n)]
vis=[0]*2001
for _ in range(m):
    a,b=map(int,input().split())
    relationship[a].append(b)
    relationship[b].append(a)

def dfs(idx,depth):
    global ans
    vis[idx]=1
    if depth==4:
        print(1)
        sys.exit()
    for i in relationship[idx]:
        if not vis[i]:
            vis[i]=1
            dfs(i,depth+1)
            vis[i]=0

for i in range(n):
    dfs(i,0)
    vis[i]=0

print(0)