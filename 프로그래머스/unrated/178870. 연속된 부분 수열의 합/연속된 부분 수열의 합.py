def solution(sequence, k):
    answer = [0,len(sequence)]
    st=0
    en=0
    s=sum(sequence[st:en+1])
    while st<=en:
        if s<k:
            en+=1
            if en==len(sequence):
                break
            s+=sequence[en]
        elif s>k:
            s-=sequence[st]
            st+=1
        else:
            if answer[1]-answer[0]+1>en-st+1:
                answer[0]=st
                answer[1]=en
            s-=sequence[st]
            st+=1
    return answer



# st=0 en=0 합이 k보다작으면 en+=1
# 합이 k보다 크면 st+=1
# 조건 만족하면 저장
# 조건 만족후 st+=1 반복
# 조건 만족하는 가장작은 길이를 가진 st,en 리턴