from collections import deque

com_num=int(input())
network_num = int(input())
network={}
for i in range(1,com_num+1):
    network[i]=[]

for _ in range(network_num):
    a,b=map(int,input().split())
    network[a].append(b)
    network[b].append(a)
vis=[False for _ in range(com_num+1)]
queue = deque(network[1])
vis[1]=True
cnt=0
while queue:
    con=queue.popleft()
    if not vis[con]:
        vis[con]=True
        cnt+=1
        for i in network[con]:
            if not vis[i]:
                queue.append(i)
print(cnt)
