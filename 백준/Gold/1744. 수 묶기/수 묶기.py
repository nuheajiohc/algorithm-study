n = int(input())
nums=[int(input()) for _ in range(n)]
result=0
minus_nums=[]
plus_nums=[]
for i in range(n):
    if nums[i]<=0:
        minus_nums.append(nums[i])
    if nums[i]>1:
        plus_nums.append(nums[i])

minus_nums.sort()
plus_nums.sort(reverse=True)

def s(Lst):
    global result
    for i in range(0,len(Lst),2):
        if i+1<len(Lst):
            result+=Lst[i]*Lst[i+1]
            continue
        result+=Lst[i]

s(minus_nums)
s(plus_nums)
result+=nums.count(1)
print(result)