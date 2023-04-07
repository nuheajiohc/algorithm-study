from itertools import permutations

def solution(k, dungeons):
    answer = 0
    p = permutations(dungeons,len(dungeons))
    for case in p:
        count=0
        temp=k
        for a,b in case:
            if temp>=a:
                temp-=b
                count+=1
            else:
                if answer<count:
                    answer=count
                    break
        else:
            if answer<count:
                answer=count
    return answer