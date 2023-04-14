# def solution(targets):
#     answer = 0
#     targets.sort(key = lambda x:(x[0],x[1]-x[0]))
#     temp=-1
#     print(targets)
#     for st,en in targets:
#         if temp<=st:
#             temp=en
#             answer+=1
#     return answer
def solution(targets):
    answer = 0
    targets.sort(key = lambda x: [x[1], x[0]])
    
    s = e = 0
    for target in targets:
        if target[0] >= e:
            answer += 1
            e = target[1]

    return answer 

# sort로 정렬
# targets[0]에서 카운트+=1
# 다음 것이 이전것의 end보다 작으면 넘어가기
# end 보다 큰 start찾기 count+=1