import sys
sys.setrecursionlimit(10**6)
t = int(input())

def dfs(i):
    while i not in temp_vis:
        if vis[i]:
            return False
        vis[i]=-1
        temp_vis.add(i)
        i = students[i]
    return i
        
def check(i,k):
    if not vis[k]==1:
        vis[k]=1
        check(i,students[k])

for _ in range(t):
    n = int(input())
    students = [0]+list(map(int,sys.stdin.readline().split()))
    vis = [0]*(n+1)
    for i in range(1,n+1):
        if not vis[i]:
            temp_vis = set()
            temp = dfs(i)
            if temp:
                check(temp,temp)

    print(vis.count(-1))