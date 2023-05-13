from collections import deque

n,k = map(int,input().split())
n_list = list(map(int,input().split()))
visit=set()
queue=deque()
for i in n_list:
    queue.append((i,0))
    visit.add(i)

ans = 0
cnt = k
def bfs(cnt,ans):
    while queue:
        x,d=queue.popleft()
        for dir in [-1,1]:
            nx=x+dir
            if nx in visit:
                continue
            queue.append((nx,d+1))
            visit.add(nx)
            ans+=d+1
            cnt-=1
            if not cnt:
                return ans
        
print(bfs(cnt,ans))