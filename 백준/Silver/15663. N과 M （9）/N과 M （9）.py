n,m = map(int,input().split())
nums = sorted(map(int,input().split()))
arr = []
vis = [False] * (n)
result=[]

def func():
    if len(arr)==m:
        result.append(tuple(arr))
        return
    
    for i in range(n):
        if not vis[i]:
            vis[i]=True
            arr.append(nums[i])
            func()
            vis[i]=False
            arr.pop()

func()
result = sorted(set(result))
for i in result:
    print(*i)
