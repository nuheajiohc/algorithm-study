def solution(numbers, target):
    answer = 0
    arr=[0]
    for i in numbers:
        temp=[]
        for j in arr:
            temp.append(j+i)
            temp.append(j-i)
        arr=temp
    answer = arr.count(target)
    return answer