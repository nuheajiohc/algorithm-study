import math

def solution(brown, yellow):
    answer = []
    s=brown+yellow
    for i in range(int(math.sqrt(s)),s+1):
        if s%i==0:
            width=i
            height=s//i
            if width<height:
                continue
            if (2*width)+2*(height-2)==brown and int(yellow/(width-2))==(yellow/(width-2)):
                answer.append(width)
                answer.append(height)
                break
    return answer


# 전체 크기는 brown+yellow = 가로 x 세로 
# 가로>=세로
# a+a+(2+b)*(세로-2)

# 2(가로)+2(세로-2)= brown
# b(세로-2) =yellow

# brown+yellow를 구하고 가로가 세로보다 크거나 같은 약수들을 구하면서 위조건에 맞는 값을 구한다.