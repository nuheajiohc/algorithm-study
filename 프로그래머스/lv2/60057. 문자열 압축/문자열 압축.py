def solution(s):
    answer = 1000
    st=0
    en=0
    l=0
    while en-st+1<=len(s): 
        cnt=1
        l+=1
        st=0
        en=l-1
        temp=s[st:en+1]
        cur_letter=""
        st+=l
        en+=l
        while True:
            if temp!=s[st:en+1]:
                if cnt==1:
                    cur_letter+=temp
                else:
                    cur_letter+=str(cnt)+temp
                temp=s[st:en+1]
                cnt=1
            else:
                cnt+=1
            if en>=len(s):
                cur_letter+=temp
                break
            st+=l
            en+=l
        answer=min(answer,len(cur_letter))
    return answer