from collections import Counter

def solution(k, tangerine):
    answer = 0
    counter=Counter(tangerine)
    arr=[]
    for i in counter:
        arr.append([i,counter[i]])
    arr.sort(key=lambda x:-x[1])
    for key,value in arr:
        if k>0:
            k-=value
            answer+=1
        else:
            break
    return answer