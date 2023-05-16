from collections import deque

x= int(input())
vis=[0]*(x+1)

q = deque([x])
while q:
    cur_x=q.popleft()
    for i in range(2,4):
        if not cur_x%i and not vis[cur_x//i]:
            vis[cur_x//i]=vis[cur_x]+1
            q.append(cur_x//i)
    if not vis[cur_x-1]:
        vis[cur_x-1]=vis[cur_x]+1
        q.append(cur_x-1)
    if cur_x<=3:
        break

print(vis[1])