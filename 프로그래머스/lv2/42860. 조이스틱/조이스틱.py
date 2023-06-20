def solution(name):
    answer = 0
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    index=0
    temp=0
    for s in name:
        idx=alphabet.index(s)
        temp += min(idx,26-idx) 
    i=0
    answer = len(name)-1
    print(temp)
    while i<len(name):
        next=i+1
        while next < len(name) and name[next]=="A":
            next+=1
        answer = min(answer,2*i + len(name)-next , i+2*(len(name)-next))
        i=next
    return answer+temp