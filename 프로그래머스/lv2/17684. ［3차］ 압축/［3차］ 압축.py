def solution(msg):
    answer = []
    idx ={}
    for i,v in enumerate("ABCDEFGHIJKLMNOPQRSTUVWXYZ",1):
        idx[v]=i
    s=""
    cur=0
    msg+=" "
    while cur<len(msg):
        s+=msg[cur]
        if s==" ":
            break
        if s not in idx:
            idx[s]=len(idx)+1
            answer.append(idx[s[:-1]])
            s=""
            continue
        cur+=1
    return answer