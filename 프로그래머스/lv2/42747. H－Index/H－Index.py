def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    for i in range(len(citations),-1,-1):
        a=0
        b=0
        for n in citations:
            if i<n:
                a+=1
            elif i==n:
                b+=1
            else:
                break
        if i-a<=b:
            answer=i
            break
    return answer