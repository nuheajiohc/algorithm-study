n = int(input())
m = int(input())
nums = list(map(int, input().split()))
check_dict={}
for i,num in enumerate(nums):
    if num in check_dict:
        check_dict[num][0]+=1
    else:
        if len(check_dict)==n:
            min_v=sorted(check_dict.items(),key=lambda x:(x[1][0],x[1][1]))[0]
            del check_dict[min_v[0]]
        check_dict[num]=[1,i]

result=sorted(check_dict.items(),key=lambda x:x[0])

print(*list(map(lambda x:x[0], result)))