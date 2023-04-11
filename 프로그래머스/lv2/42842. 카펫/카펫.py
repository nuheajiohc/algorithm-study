import math

def solution(brown, yellow):
    answer = []
    area=brown+yellow
    height=0
    width=0
    for i in range(math.ceil(math.sqrt(area)),area):
        width=i
        height=area//width
        if brown==(width*2)+(height-2)*2 and yellow/(height-2) ==yellow//(height-2):
            break
    answer.append(width)
    answer.append(height)
    return answer


# brown = 가로*2 + (세로-2)*2
# yellow = (세로-2)* x
# 가로>=세로