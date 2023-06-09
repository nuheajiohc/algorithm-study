def solution(routes):
    answer = 1
    routes.sort(key=lambda x:x[1])
    temp=routes[0]
    for i in range(1,len(routes)):
        if temp[1]<routes[i][0]:
            temp=routes[i]
            answer+=1        
    return answer