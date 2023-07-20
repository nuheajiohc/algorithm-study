import sys 
sys.setrecursionlimit(10**6)

t = int(input())

def dfs(i):
    global count
    vis[i]=1
    cycle_list.append(i)
    if vis[stu[i]]:
        if stu[i] in cycle_list:
            count -= len(cycle_list[cycle_list.index(stu[i]):])
        return
    else:
        dfs(stu[i])

for _ in range(t):
    n = int(input())
    stu = [0]+list(map(int,sys.stdin.readline().split()))
    vis = [0]*(n+1)
    count=n
    for i in range(1,n+1):
        if not vis[i]:
            cycle_list = []
            dfs(i)
    
    print(count)