def solution(storey):
    answer = 0
    temp = storey

    while temp:
        b=temp%10
        if b>5:
            answer +=(10-b)
            temp+=10
        elif b==5:
            answer+=5
            if temp//10%10>4:
                temp+=10
        else:
            answer+=b
        temp//=10
    return answer

# 자리수 > 5   answer += (10-숫자)  , 전체숫자에 다음자리수 +10
# 자리수 == 5  answer += 5  , 다음 자리수+1이 >5 면 전체숫자에 다음자리수 +10  아니면 넘어가기
# 자리수 < 5   answer += 자리수
# 자리수 == 0  넘어가기