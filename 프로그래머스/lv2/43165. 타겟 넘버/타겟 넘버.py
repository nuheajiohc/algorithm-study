def solution(numbers, target):
    nums=[0]
    for i in numbers:
        temp=[]
        for j in nums:
            temp.append(j+i)
            temp.append(j-i)
        nums=temp
    return nums.count(target)