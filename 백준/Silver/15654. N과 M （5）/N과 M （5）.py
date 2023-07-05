n,m = map(int,input().split())
nums = sorted(map(int,input().split()))
arr=[]

def func():
    if len(arr)==m:
        print(*arr)
        return
    
    for i in range(n):
        if nums[i] not in arr:
            arr.append(nums[i])
            func()
            arr.pop()

func()