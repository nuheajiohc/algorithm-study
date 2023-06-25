from decimal import Decimal

def solution(lines):
    answer = 1
    times = []
    for line in lines:
        a,b,c=line.split()
        h=int(b[:2])
        m=int(b[3:5])
        s=int(b[6:8])
        ms=int(b[9:])
        
        duration_time = float(c[:-1])
        en_time = (h*60*60 + m*60 + s)*1000 + ms
        st_time = en_time+1-(duration_time*1000)
        
        times.append([st_time,en_time])
 
    # for i in range(len(times)):
    #     temp=1
    #     en = times[i][1]
    #     en_plus_one  = en+1000
    #     j=i+1
    #     while j<len(times) and en_plus_one>times[j][0]:
    #         temp+=1
    #         j+=1
    #     answer=max(answer,temp)
    for i in range(len(times)):
        en = times[i][1]
        temp=0
        for j in range(i,len(times)):
            if en+1000 > times[j][0]:
                temp+=1
        answer = max(temp,answer)
    return answer