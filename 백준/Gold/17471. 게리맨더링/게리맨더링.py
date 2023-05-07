from itertools import combinations
from collections import deque

N = int(input())
population = [0] + list(map(int,input().split()))
poplation_sum = sum(population)

network={}
area = set(range(1,N+1))
min_diff=2e9

for i in range(1,N+1):
    if i not in network:
        network[i]=[]
    area_info =list(map(int,input().split()))[1:]
    for j in area_info:
        network[i].append(j)

def bfs(arr):
    queue=deque([arr[0]])
    vis=[0 for _ in range(N+1)]
    vis[arr[0]]=1
    while queue:
        cur_pos=queue.popleft()
        for i in network[cur_pos]:
            if vis[i]:
                continue
            if not vis[i] and i not in arr:
                continue
            vis[i]=1
            queue.append(i)
    
    if vis.count(1)==len(arr):
        return True
    else:
        return False

def diff(arr):
    s=0
    for i in arr:
        s+=population[i]
    return abs(poplation_sum-2*s)
        
for i in range(1,N//2+1):
    c=combinations(range(1,N+1),i)
    for area1 in c:
        area2=[j for j in range(1,N+1) if j not in area1]
        if not bfs(area1) or not bfs(area2):
            continue
        
        min_diff= min(min_diff,diff(area1))

if min_diff==2e9:
    print(-1)
else:
    print(min_diff)