def solution(phone_book):
    answer = True
    check=set()
    for s in phone_book:
        for i in range(1,len(s)):
            check.add(s[0:i])
    for s in phone_book:
        if s in check:
            answer=False
            break       
    else:
        return answer
    return answer