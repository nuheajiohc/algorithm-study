def solution(people, limit):
    answer = 0
    s_p=sorted(people)
    st=0
    en=len(s_p)-1
    while st<=en:
        if st==en:
            answer+=1
            break
        if s_p[st]+s_p[en]<=limit:
            st+=1
            en-=1
            answer+=1
        else:
            en-=1
            answer+=1
    return answer