n = int(input())
nums = list(map(int,input().split()))
add, sub, mul, div = map(int,input().split())
max_value = -1000000000
min_value = 1000000000

def func(depth,result):
    global add,sub,mul,div,max_value,min_value

    if depth == n:
        max_value = max(max_value, result)
        min_value = min(min_value, result)
    else:
        if add>0:
            add-=1
            func(depth+1,result+nums[depth])
            add+=1
        if sub>0:
            sub-=1
            func(depth+1,result-nums[depth])
            sub+=1
        if mul>0:
            mul-=1
            func(depth+1,result*nums[depth])
            mul+=1
        if div>0:
            div-=1
            func(depth+1,int(result/nums[depth]))
            div+=1

func(1,nums[0])
print(max_value,min_value,sep="\n")