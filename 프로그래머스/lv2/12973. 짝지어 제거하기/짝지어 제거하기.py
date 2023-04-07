def solution(s):
    answer = -1
    stack=[]
    for i in s:
        if len(stack)==0:
            stack.append(i)
            continue
        else:
            if i==stack[-1]:
                stack.pop()
            else:
                stack.append(i)
    if len(stack):
        answer=0
    else :
        answer=1
    return answer