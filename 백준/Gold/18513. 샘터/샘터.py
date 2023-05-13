from collections import deque

n,k = map(int,input().split())
water=list(map(lambda x:int(x)+150000000,input().split()))
vis=[0]*300000000
water_set=set()
for v in water:
    water_set.add(v)
ans=0
cnt=k
def bfs(cnt,ans):
    queue = deque(water)
    while queue:
        x=queue.popleft()
        for dir in [1,-1]:
            nx=x+dir
            if nx in water_set:
                continue
            if vis[nx]:
                continue
            vis[nx]=vis[x]+1
            ans+=vis[nx]
            cnt-=1
            queue.append(nx)
            if cnt==0:
                return ans

print(bfs(cnt,ans))