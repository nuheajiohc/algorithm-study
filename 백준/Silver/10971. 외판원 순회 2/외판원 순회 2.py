n = int(input())
network = [list(map(int,input().split())) for _ in range(n)]
min_cost = 1000000*n
vis = [0]*n
vis[0]=1

def func(depth,st,cost):
    global min_cost
    if depth == n and network[st][0]:
        min_cost = min(min_cost,cost+network[st][0])
        return
    
    for en in range(n):
        if not vis[en] and network[st][en]:
            cost+=network[st][en]
            vis[en]=1
            func(depth+1,en,cost)
            cost-=network[st][en]
            vis[en]=0

func(1,0,0)
print(min_cost)