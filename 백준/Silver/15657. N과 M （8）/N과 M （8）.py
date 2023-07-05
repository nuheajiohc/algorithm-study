n,m = map(int,input().split())
nums = sorted(map(int,input().split()))
arr=[]

def func(k):
    if len(arr)==m:
        print(*arr)
        return
    
    for i in range(k,n):
        arr.append(nums[i])
        func(i)
        arr.pop()

func(0)