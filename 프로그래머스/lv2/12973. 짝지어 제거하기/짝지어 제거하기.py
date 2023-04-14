def solution(s):
    answer = -1
    stack=[]
    for v in s:
        if len(stack) and stack[-1]==v:
            stack.pop()
        else:
            stack.append(v)
        
    if len(stack):
        answer=0
    else:
        answer=1
    return answer