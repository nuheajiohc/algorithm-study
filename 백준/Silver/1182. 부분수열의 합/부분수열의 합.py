n,s = map(int,input().split())
nums = list(map(int,input().split()))
count=0
arr = []
def dfs(k):
    global count

    for i in range(k,n):
        arr.append(nums[i])
        if sum(arr)==s:
            count+=1
        dfs(i+1)
        arr.pop()

dfs(0)
print(count)