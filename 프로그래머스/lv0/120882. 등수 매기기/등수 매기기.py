def solution(score):
    answer = []
    scoremap = list(map(lambda x:[x,1],score))
    for i in scoremap:
        for j in scoremap:
            if i[0][0]+i[0][1] < j[0][0]+j[0][1]:
                i[1]+=1
    answer = list(map(lambda x:x[1],scoremap))
    return answer